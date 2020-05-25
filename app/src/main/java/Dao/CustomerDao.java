package Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import Model.Customer;

@Dao
public interface CustomerDao {
    @Insert
    void insert(Customer customer);

    @Query("Update Customer set name=:name")
    void update(String name);

    @Delete
    void delete(Customer customer);

    @Query("SELECT * FROM Customer WHERE id=:customerId")
    Customer findById(String customerId);

    @Query("SELECT * FROM Customer")
    List<Customer> findAll();


}
