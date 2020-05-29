package com.example.myapplication.product_type_ui;

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

import com.example.myapplication.ItemAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.Proion;
import db.AppDatabase;

public class SmartwatchFragment extends Fragment {

    ListView listView;

    List<String> names = new ArrayList<>();
    List<String> description = new ArrayList<>();
    List<Double> price = new ArrayList<>();
    List<String> id = new ArrayList<>();
    ArrayList<Integer> quantities = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_smartwatches,container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                List<Proion> products = db.proionDataAccessObject().findAll();

                for (
                        int i = 0; i < products.size(); i++) {
                    if (products.get(i).getType() == 4) {
                        names.add(products.get(i).getName());
                        description.add(products.get(i).getPerigrafi());
                        price.add(products.get(i).getKostos());
                        id.add(products.get(i).getId());
                        quantities.add(products.get(i).getApothema());
                    }
                }

                getActivity().runOnUiThread((new Runnable() {
                    @Override
                    public void run() {

                        listView = getActivity().findViewById(R.id.smartwachtlist);
                        ItemAdapter itemAdapter = new ItemAdapter(SmartwatchFragment.this.getActivity(), names, description, price, id, quantities);
                        listView.setAdapter(itemAdapter);
                    }
                }));


            }
        });

    }
}
