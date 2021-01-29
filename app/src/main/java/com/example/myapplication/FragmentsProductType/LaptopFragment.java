package com.example.myapplication.FragmentsProductType;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.myapplication.Adapters.ItemAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.Proion;
import db.AppDatabase;

public class LaptopFragment extends Fragment{
    private ListView listview;

    private List<String> names = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();
    private List<Double> prices = new ArrayList<>();
    private List<String> ids = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_laptop, container, false);            //Αυτό το Fragment ανοίγει όταν πατηθεί το/η Card/Κατηγορία Laptop
    }

    @Override
    public void onStart() {
        super.onStart();
        final AppDatabase db = Room.databaseBuilder(getActivity(),                                  // Θέτω το db ώστε να έχω πρόσβαση στην βάση
                AppDatabase.class, "eshop").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {         // Κάθε φορά που χρησιμοποιώ την βάση ανοίξει το Async Task ώστε να τρέξει σε άλλο Thread
                                        // και να μην εμποδίσει το UI
                        List<Proion> products = db.proionDataAccessObject().findAll();              // Παίρνω όλα τα προϊόντα από την βάση
                        for (int i = 0; i < products.size(); i++) {
                            if (products.get(i).getType() == 1) {                                   // Διαλέγω τα προϊόντα τύπου Laptop (κωδικός 1)
                                names.add(products.get(i).getName());                               // Χωρίζω τα πεδία του σε λίστες
                                descriptions.add(products.get(i).getPerigrafi());
                                prices.add(products.get(i).getKostos());
                                ids.add(products.get(i).getId());
                                quantities.add(products.get(i).getApothema());
                            }
                        }

                getActivity().runOnUiThread((new Runnable() {
                    @Override
                    public void run() {
                        listview = getActivity().findViewById(R.id.laptoplist);
                        ItemAdapter itemAdapter = new ItemAdapter(LaptopFragment.this.getActivity(), names, descriptions, prices, ids,quantities);  // Περνάω τα προϊόντα τύπου Laptop
                        listview.setAdapter(itemAdapter);                                                                                           // στον Adapter ώστε να τα εμφανίσει
                    }                                                                                                                               // στην λίστα Laptops
                }));
            }


        });
    }
}
