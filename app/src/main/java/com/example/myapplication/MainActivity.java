package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.FragmentsDrawerMenu.CartFragment;
import com.example.myapplication.FragmentsDrawerMenu.EditFragment;
import com.example.myapplication.FragmentsDrawerMenu.QuestionsFragment;
import com.example.myapplication.FragmentsDrawerMenu.ShopFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopFragment()).commit(); // Θέτω ως αρχικό Fragment το κατάστημα
            navigationView.setCheckedItem(R.id.nav_shop);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {       // Αν είναι ανοιχτό το Drawer Menu όταν πατηθεί το back button τότε κλείνει το Menu και όχι ολόκληρο το app.
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            int count = getSupportFragmentManager().getBackStackEntryCount();   // Με την βοήθεια του BackStack βλέπω πόσα Fragments έχουν ανοίξει.
            if (count == 0) {
                super.onBackPressed();                                          // Αν δεν έχουν ανοίξει κλείνει η εφαρμογή
            } else {
                getSupportFragmentManager().popBackStack();                     // Αν έχουν ανοίξει πηγαίνει στο προηγούμενο
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {                                                                 // Ποιο Fragment θα ανοίξει από το Drawer Menu
            case R.id.nav_shop:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ShopFragment(),"CART_FRAGMENT").addToBackStack(null).commit();
                break;
            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CartFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_questions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QuestionsFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_edit:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EditFragment()).addToBackStack(null).commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);                                              // Όταν γίνει η επιλογή κλείνει το Drawer Menu
        return true;
    }



}
