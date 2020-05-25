package Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import Model.Product;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);
    @Query("Update Product set name=:name")
    void update(String name);
    @Delete
    void delete(Product product);

    @Query("SELECT * FROM Product WHERE id=:productId")
    Product findById(String productId);

    @Query("SELECT * FROM Product")
    List<Product> findAll();

}
