package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.UUID;

import Model.Kalathi;
import Model.Pelatis;
import Model.Polisi;
import Model.Proion;
import db.AppDatabase;

public class ConfirmFinalOrderFragment extends Fragment {

    private EditText nameEditText, phoneEditText, addressEditText, emailEditText;
    private Button confirmOrderBtn;
    private Polisi polisi;
    private Pelatis pelatis;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        confirmOrderBtn = getActivity().findViewById(R.id.confirm_final_order_btn);
        nameEditText = getActivity().findViewById(R.id.shipment_name);
        phoneEditText = getActivity().findViewById(R.id.shipment_phone);
        addressEditText = getActivity().findViewById(R.id.shipment_home_address);

        emailEditText = getActivity().findViewById(R.id.shipment_email);


        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        System.out.println(nameEditText.getText());
        System.out.println(phoneEditText.getText());
        System.out.println(addressEditText.getText());
        System.out.println(emailEditText.getText());


        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(nameEditText.getText().toString().equals("")) || !(phoneEditText.getText().toString().equals("")) || !(addressEditText.getText().toString().equals(""))
                        || !(emailEditText.getText().toString().equals(""))) {
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            pelatis = new Pelatis(UUID.randomUUID().toString(), nameEditText.getText().toString(), addressEditText.getText().toString(), emailEditText.getText().toString(), phoneEditText.getText().toString());
                            List<Kalathi> kalathi = db.kalathiDataAccessObject().findAll();
                            List<String> ids = db.kalathiDataAccessObject().findIds();
                            Proion proion;
                            for (int i = 0; i < ids.size(); i++) {

                                String proionId = ids.get(i);
                                proion = db.proionDataAccessObject().findById(proionId);
                                polisi = new Polisi(UUID.randomUUID().toString(), proionId, pelatis.getId(), 1);
                                int neoApothema = proion.getApothema();
                                neoApothema--;
                                db.proionDataAccessObject().update(proionId, neoApothema);
                                db.kalathiDataAccessObject().delete(kalathi.get(i));
                            }
                        }
                    });

                    Toast.makeText(getActivity(), "Επιτυχής συναλλαγή!", Toast.LENGTH_LONG).show();
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopFragment()).commit();
                } else {
                    Toast.makeText(getActivity(), "Δεν έδωσες όλα τα στοιχεία σου.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}




