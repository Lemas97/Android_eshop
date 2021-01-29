package com.example.myapplication.FragmentsQuestions;

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

import com.example.myapplication.Adapters.QuantityAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.Proion;
import db.AppDatabase;

public class QuantitiesFragment extends Fragment {
    ListView listview;
    List<String> names = new ArrayList<>();;
    List<Integer> quantities = new ArrayList<>();;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_questions_quantities, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final List<Proion> proions = db.proionDataAccessObject().findAll();

                getActivity().runOnUiThread((new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<proions.size(); i++) {
                            //Περνάω τα πεδία των προϊόντων σε λίστες
                            names.add(proions.get(i).getName());
                            quantities.add(proions.get(i).getApothema());
                        }
                        listview = getActivity().findViewById(R.id.quantitiesList);
                        QuantityAdapter quantityAdapter = new QuantityAdapter(QuantitiesFragment.this.getActivity(),names,quantities);   //Περνάω τις λίστες στον QuestionsQuantityAdapter
                        listview.setAdapter(quantityAdapter);
                    }
                }));
            }
        });



    }
}
