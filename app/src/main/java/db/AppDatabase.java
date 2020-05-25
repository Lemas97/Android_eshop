package db;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import Dao.CustomerDao;
import Dao.ProductDao;
import Dao.SaleDao;
import Model.Customer;
import Model.Product;

import Model.Sale;

@Database(entities = {Customer.class, Product.class, Sale.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CustomerDao customerDao();
    public abstract ProductDao productDao();
    public abstract SaleDao saleDao();

}
