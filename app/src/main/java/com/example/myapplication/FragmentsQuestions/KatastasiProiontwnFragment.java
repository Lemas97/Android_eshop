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

import com.example.myapplication.Adapters.KatastasiProiontwnAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.Proion;
import db.AppDatabase;

public class KatastasiProiontwnFragment extends Fragment {
    private ListView listview;
    private List<String> names = new ArrayList<>();
    private List<Integer> apothemata = new ArrayList<>();
    private List<Double> kostoi = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_katastasi_pelatwn, container, false); //Αυτό το Fragment ανοίγει μετά την επιλογή κουμπιού στο QuestionFragment
    }

    @Override
    public void onStart() {
        super.onStart();

        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Proion> proionta = db.proionDataAccessObject().findAll();  //Περνάω όλα τα προϊόντα σε μια λίστα

                for (Proion proion:proionta){
                    //Περνάω σε κατάλληλες λίστες τα πεδία των προϊόντων
                    names.add(proion.getName());
                    apothemata.add(proion.getApothema());
                    kostoi.add(proion.getKostos());

                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        listview = getActivity().findViewById(R.id.katastasi_pelatwn_list);
                        KatastasiProiontwnAdapter katastasiPelatwnAdapter = new KatastasiProiontwnAdapter(KatastasiProiontwnFragment.this.getActivity(),names, apothemata, kostoi);
                        listview.setAdapter(katastasiPelatwnAdapter); //Τα στέλνω στον KatastasiProiontwnAdapter ώστε να δημιουργήσει δυναμικά την λίστα
                    }
                });
            }
        });
    }
}
