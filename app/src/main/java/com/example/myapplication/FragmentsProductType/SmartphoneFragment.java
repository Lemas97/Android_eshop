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

public class SmartphoneFragment extends Fragment {

    private ListView listView;
    private List<String> names = new ArrayList<>();
    private List<String> description = new ArrayList<>();
    private List<Double> price = new ArrayList<>();
    private List<String> id = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_smartphone,container, false);        //Αυτό το Fragment ανοίγει όταν πατηθεί το/η Card/Κατηγορία SmartPhone
    }

    @Override
    public void onStart() {
        super.onStart();
        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Proion> products = db.proionDataAccessObject().findAll();                      // Παίρνω όλα τα προϊόντα από την βάση
                for (
                        int i = 0; i < products.size(); i++) {
                    if (products.get(i).getType() == 2) {                                           // Διαλέγω τα προϊόντα τύπου SmartPhone (κωδικός 2)
                        names.add(products.get(i).getName());                                       // Χωρίζω τα πεδία του σε λίστες
                        description.add(products.get(i).getPerigrafi());
                        price.add(products.get(i).getKostos());
                        id.add(products.get(i).getId());
                        quantities.add(products.get(i).getApothema());
                    }
                }
                getActivity().runOnUiThread((new Runnable() {
                    @Override
                    public void run() {

                        listView = getActivity().findViewById(R.id.smartphonelist);
                        ItemAdapter itemAdapter = new ItemAdapter(SmartphoneFragment.this.getActivity(), names, description, price, id,quantities); // Περνάω τα προϊόντα τύπου SmartPhone
                        listView.setAdapter(itemAdapter);                                                                                           // στον Adapter ώστε να τα εμφανίσει
                    }
                }));                                                                                                                                // στην λίστα SmartPhones
            }
        });
    }
}

