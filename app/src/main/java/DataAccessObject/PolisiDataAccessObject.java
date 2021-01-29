package DataAccessObject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Model.Polisi;

@Dao
public interface PolisiDataAccessObject {

    @Insert
    void insert(Polisi polisi); //Εισαγωγή πώλησης στην βάση

    @Delete
    void delete(Polisi polisi); //Διαγραφή πώλησης από την βάση

    @Query("SELECT * FROM Polisi WHERE id=:polisiId")
    Polisi findById(String polisiId);   //Εύρεση πώλησης από το id της πώλησης

    @Query("SELECT * FROM Polisi WHERE proionId=:proionId")
    List<Polisi> findByProductId(String proionId);  //Εύρεση πώληση από το id των πρωϊόντων

    @Query("SELECT * FROM Polisi")
    List<Polisi> findAll();     //Εύρεση όλων των πωλήσεων

}
