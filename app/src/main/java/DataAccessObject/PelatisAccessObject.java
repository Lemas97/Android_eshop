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
    void insert(Pelatis pelatis); //Εισαγωγή πελάτη σητν βάση

    @Query("Update Pelatis set name=:name")
    void update(String name);   // Update το όνομα του πελάτη

    @Delete
    void delete(Pelatis customer);  //Διαγραφή πελάτη

    @Query("SELECT * FROM Pelatis WHERE id=:pelatisId")
    Pelatis findById(String pelatisId); //Εύρεση πελατών από το id τους

    @Query("SELECT * FROM Pelatis")
    List<Pelatis> findAll(); //Εύρεση όλων τον πελατών


}
