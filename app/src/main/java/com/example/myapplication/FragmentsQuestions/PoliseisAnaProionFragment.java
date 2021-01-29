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

import com.example.myapplication.Adapters.PoliseisAnaProionAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.Polisi;
import Model.Proion;
import db.AppDatabase;

public class PoliseisAnaProionFragment extends Fragment {
    ListView listview;
    List<String> names = new ArrayList<>();
    List<Integer> quantities = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_poliseis_ana_proion, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {



                final List<Proion> proions = db.proionDataAccessObject().findAll(); //Περνάω όλα τα προϊόντα σε μια λίστα


                for (Proion proion:proions){
                    names.add(proion.getName());                                                        //Περνάω το όνομα του προϊόντος σε μια λίστα

                    List<Polisi> polisis = db.polisiDataAccessObject().findByProductId(proion.getId()); //Βρίσκω τις πωλήσεις με βάσι το id των προϊόντων

                    int poliseisProiontos =0;   //Μετριτής πώλησης ανα προϊόν
                    for (Polisi polisi:polisis){
                        poliseisProiontos += polisi.getPosotita(); //Υπολογισμός ποσότητας πώλησης ανά προϊόν
                    }
                    quantities.add(poliseisProiontos);  //Περνάω την ποσότητα σε μια λίστα
                }


                getActivity().runOnUiThread((new Runnable() {
                    @Override
                    public void run() {
                        listview = getActivity().findViewById(R.id.sunolikes_poliseis_List);
                        //Περνάω το όνομα και την ποσότητα του προϊόντος στον PoliseisAnaProionAdapter ώστε να δημιουργηθεί δυναμικά η λίστα με τις ποσότητες
                        PoliseisAnaProionAdapter poliseisAnaProionAdapter = new PoliseisAnaProionAdapter(PoliseisAnaProionFragment.this.getActivity(),names, quantities);
                        listview.setAdapter(poliseisAnaProionAdapter);
                    }
                }));
            }
        });



    }
}
