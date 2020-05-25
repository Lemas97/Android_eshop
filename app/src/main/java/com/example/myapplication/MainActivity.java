package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.UUID;

import Model.Customer;
import Model.Product;
import Model.Sale;
import db.AppDatabase;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_shop);
        }

        //      ***************      DATABASE      ***************       //

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "eshop").build();


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {                 //Νεο thread ώστε να μην καθηστερεί το ui
                Customer customer = new Customer(UUID.randomUUID().toString(), "Raf", "xd odos 25");
                Product product = new Product(UUID.randomUUID().toString(), "gala", "neogal", 3.5, 20,2);
                Sale sale = new Sale(UUID.randomUUID().toString(), product.getId(), customer.getId(), 3);

                db.customerDao().insert(customer);
                db.productDao().insert(product);
                db.saleDao().insert(sale);

                List<Customer> customers = db.customerDao().findAll();
                List<Product> products = db.productDao().findAll();
                List<Sale> sales = db.saleDao().findAll();

                System.out.println(customers);
                System.out.println(products);
                System.out.println(sales);

            }
        });

    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            int count = getSupportFragmentManager().getBackStackEntryCount();
            if (count == 0) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_shop:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ShopFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CartFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_questions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QuestionsFragment()).addToBackStack(null).commit();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
