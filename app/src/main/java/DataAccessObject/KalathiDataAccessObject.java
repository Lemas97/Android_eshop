package DataAccessObject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Kalathi;
import Model.Polisi;

@Dao
public interface KalathiDataAccessObject {

    @Insert
    void insert(Kalathi kalathi);


    @Delete
    void delete(Kalathi kalathi);

    @Query("Update kalathi set posotita = :posotita where id = :id")
    void update(String id, int posotita);

    @Query("SELECT * FROM Kalathi")
    List<Kalathi> findAll();

    @Query("SELECT proionId FROM Kalathi")
    List<String> findIds();

    @Query("SELECT * FROM Kalathi WHERE proionId = :proionId")
    List<Kalathi> findByProductId(List<String> proionId);

}
