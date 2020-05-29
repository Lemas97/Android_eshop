package DataAccessObject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import Model.Pelatis;

@Dao
public interface PelatisAccessObject {
    @Insert
    void insert(Pelatis pelatis);

    @Query("Update Pelatis set name=:name")
    void update(String name);

    @Delete
    void delete(Pelatis customer);

    @Query("SELECT * FROM Pelatis WHERE id=:pelatisId")
    Pelatis findById(String pelatisId);

    @Query("SELECT * FROM Pelatis")
    List<Pelatis> findAll();


}
