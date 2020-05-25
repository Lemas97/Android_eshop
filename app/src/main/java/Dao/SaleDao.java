package Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Model.Sale;

@Dao
public interface SaleDao {

    @Insert
    void insert(Sale sale);


    @Delete
    void delete(Sale sale);

    @Query("SELECT * FROM Sale WHERE id=:saleId")
    Sale findById(String saleId);

    @Query("SELECT * FROM Sale")
    List<Sale> findAll();

}
