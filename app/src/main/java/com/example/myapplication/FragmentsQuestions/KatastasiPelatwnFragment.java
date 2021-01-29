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

import com.example.myapplication.Adapters.KatastasiPelatwnAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.Pelatis;
import db.AppDatabase;

public class KatastasiPelatwnFragment extends Fragment {
    private ListView listview;
    private List<String> names = new ArrayList<>();
    private List<String> email = new ArrayList<>();
    private List<String> phones = new ArrayList<>();
    private List<String> addresses = new ArrayList<>();
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
                List<Pelatis> pelates = db.pelatisDataAccessObject().findAll(); //Περνάω όλους τους πελάτες σε μια λίστα

                for (Pelatis pelatis:pelates){
                    //Περνάω σε κατάλληλες λίστες τα πεδία των πελατών
                    names.add(pelatis.getName());
                    email.add(pelatis.getEmail());
                    phones.add(pelatis.getTilifono());
                    addresses.add(pelatis.getDiefthinsi());
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listview = getActivity().findViewById(R.id.katastasi_pelatwn_list);
                        KatastasiPelatwnAdapter katastasiPelatwnAdapter = new KatastasiPelatwnAdapter(KatastasiPelatwnFragment.this.getActivity(),names, email,phones,addresses);
                        listview.setAdapter(katastasiPelatwnAdapter);       //Τα στέλνω στον KatastasiPelatwnAdapter ώστε να δημιουργήσει δυναμικά την λίστα
                    }
                });
            }
        });
    }
}
