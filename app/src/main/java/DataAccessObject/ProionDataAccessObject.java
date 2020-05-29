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
    void insert(Proion proion);
    @Query("Update Proion set apothema=:apothema where id = :id")
    void update(String id,int apothema);
    @Delete
    void delete(Proion proion);


    @Query("SELECT * FROM Proion WHERE id=:proionId")
    Proion findById(String proionId);

    @Query("SELECT * FROM Proion")
    List<Proion> findAll();

}
