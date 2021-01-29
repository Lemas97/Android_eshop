package com.example.myapplication.FragmentsQuestions;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.Polisi;
import db.AppDatabase;

public class SunolikesPoliseisFragment extends Fragment {
    private List<Polisi> poliseis = new ArrayList<>();
    private int sunolikes_poliseis = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sunolikes_poliseis, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                poliseis = db.polisiDataAccessObject().findAll();   //Βρίσκω όλες τις πωλήσεις από την βάση

                for (int i=0; i<poliseis.size(); i++){
                    Polisi polisi = poliseis.get(i);
                    //Προσθέτω τις πωλήσεις κάθε προϊόντος
                    sunolikes_poliseis += polisi.getPosotita();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView sunolikesPoliseisTxt = getActivity().findViewById(R.id.sunolikesPoliseisTxt);
                        sunolikesPoliseisTxt.setText(String.valueOf(sunolikes_poliseis)); //Εμφανίζω τις συνολικές πωλήσεις στο TextView
                    }
                });
            }
        });
    }
}
