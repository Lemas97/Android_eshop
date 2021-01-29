package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.myapplication.FragmentsDrawerMenu.ShopFragment;

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
        //Προσδιορισμός των EditText
        nameEditText = getActivity().findViewById(R.id.shipment_name);
        phoneEditText = getActivity().findViewById(R.id.shipment_phone);
        addressEditText = getActivity().findViewById(R.id.shipment_home_address);
        emailEditText = getActivity().findViewById(R.id.shipment_email);

        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(nameEditText.getText().toString().equals("") || phoneEditText.getText().toString().equals("") || addressEditText.getText().toString().equals("") || emailEditText.getText().toString().equals(""))) {
                    //Αν όλα τα EditText δεν είναι κενά

                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            pelatis = new Pelatis(UUID.randomUUID().toString(), nameEditText.getText().toString(), addressEditText.getText().toString(),
                                    emailEditText.getText().toString(), phoneEditText.getText().toString());    // Δημιουργία καινούριου πελάτη στην βάση με τα στοιχεία που έβαλε ο χρήστης

                            List<Kalathi> kalathi = db.kalathiDataAccessObject().findAll();         //Βρίσκω όλα τα καλάθια ώστε να μπορέσω να τα σβήσω από την βάση
                            List<String> ids = db.kalathiDataAccessObject().findIds();              //Βρίσκω τα ids των προϊόντων που βρίσκονται στο καλάθι
                            Proion proion;
                            for (int i = 0; i < ids.size(); i++) {
                                String proionId = ids.get(i);
                                proion = db.proionDataAccessObject().findById(proionId);
                                polisi = new Polisi(UUID.randomUUID().toString(), proionId, pelatis.getId(), 1); //Δημιουργία καινούριας πώλησης

                                int neoApothema = proion.getApothema();                             // Παίρνω το απόθεμα του προϊόν που αγοράστηκε
                                neoApothema--;                                                      //το μειώνω κατά 1
                                db.proionDataAccessObject().update(proionId, neoApothema);          //κάνω update το απόθεμα στην βάση

                                db.polisiDataAccessObject().insert(polisi);                         // Εισαγωγή της πώλησης στην βάση
                                db.kalathiDataAccessObject().delete(kalathi.get(i));                // Διαγραφή καλαθιού

                            }
                        }
                    });
                    InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);  // Κλείσιμο του keyboard
                    Toast.makeText(getActivity(), "Επιτυχής συναλλαγή!", Toast.LENGTH_LONG).show();
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopFragment()).commit(); // Επιστροφή στο ShopFragment

                } else {
                    Toast.makeText(getActivity(), "Δεν έδωσες όλα τα στοιχεία σου.", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}




