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
    void insert(Kalathi kalathi);   //Εισαγωγή καλαθιού στην βάση


    @Delete
    void delete(Kalathi kalathi); //Διαγραφή καλαθιού από την βάση

    @Query("Update kalathi set posotita = :posotita where id = :id")
    void update(String id, int posotita);       // Update ποσότητας καθαθιού

    @Query("SELECT * FROM Kalathi")
    List<Kalathi> findAll();                    // Όλα τα καλάθια σε μια λίστα

    @Query("SELECT proionId FROM Kalathi")
    List<String> findIds();                     // Όλα τα ids των προϊόντων μέσα στο καλάθι


}
