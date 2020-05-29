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

public class LaptopFragment extends Fragment{
    ListView listview;

    List<String> names = new ArrayList<>();
    List<String> descriptions = new ArrayList<>();
    List<Double> prices = new ArrayList<>();
    List<String> ids = new ArrayList<>();
    List<Integer> quantities = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_laptop, container, false);
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
                        for (int i = 0; i < products.size(); i++) {
                            if (products.get(i).getType() == 1) {
                                names.add(products.get(i).getName());
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
                        ItemAdapter itemAdapter = new ItemAdapter(LaptopFragment.this.getActivity(), names, descriptions, prices, ids,quantities);
                        listview.setAdapter(itemAdapter);


                    }
                }));

            }


        });

    }
}
