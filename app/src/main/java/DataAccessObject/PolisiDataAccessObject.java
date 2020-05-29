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
    void insert(Polisi polisi);


    @Delete
    void delete(Polisi polisi);

    @Query("SELECT * FROM Polisi WHERE id=:polisiId")
    Polisi findById(String polisiId);

    @Query("SELECT * FROM Polisi")
    List<Polisi> findAll();

}
