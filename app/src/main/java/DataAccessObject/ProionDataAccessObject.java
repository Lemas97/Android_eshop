package DataAccessObject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import Model.Proion;

@Dao
public interface ProionDataAccessObject {

    @Insert
    void insert(Proion proion); //Εισαγωή προϊόντως στην βάση

    @Query("Update Proion set apothema=:apothema where id = :id")
    void update(String id,int apothema);    //Update του αποθέματος ενός προϊόντως

    @Delete
    void delete(Proion proion); //Διαγραφή προϊόντως από την βάση


    @Query("SELECT * FROM Proion WHERE id=:proionId")
    Proion findById(String proionId);   //Εύρεση προϊόντως από την βάση με βάση το id

    @Query("SELECT * FROM Proion")
    List<Proion> findAll(); //Εύρεση όλων τον προϊόντων

}
