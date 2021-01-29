package com.example.myapplication.FragmentsDrawerMenu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.myapplication.R;

import java.util.UUID;

import Model.Pelatis;
import Model.Proion;
import db.AppDatabase;

public class EditFragment extends Fragment {

    private Button insertPelatis,insertProion;
    private EditText newPelatisNameTxt,newPelatisEmailTxt, newPelatisAddressTxt, newPelatisPhoneTxt, newProionNameTxt, newProionDescriptionTxt, newProionPriceTxt, newProionQuantity;
    private RadioGroup newProionType;
    private RadioButton radioButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit,container, false); //Αυτό το Fragment ανοίγει όταν επιλεχθεί η Επεξεργασία από το Drawer Menu
    }

    @Override
    public void onStart() {
        super.onStart();

        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        insertPelatis = getActivity().findViewById(R.id.insertPelatisBtn);
        insertPelatis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                        //Όταν πατηθεί το κουμπί Προσθήκη Πελάτη

                newPelatisNameTxt = getActivity().findViewById(R.id.newPelatisNameTxt);
                newPelatisEmailTxt = getActivity().findViewById(R.id.newPelatisEmailTxt);
                newPelatisAddressTxt = getActivity().findViewById(R.id.newPelatisAddressTxt);
                newPelatisPhoneTxt = getActivity().findViewById(R.id.newPelatisPhoneTxt);

                String name = String.valueOf(newPelatisNameTxt.getText());
                String email = String.valueOf(newPelatisNameTxt.getText());
                String address = String.valueOf(newPelatisNameTxt.getText());
                String phone = String.valueOf(newPelatisNameTxt.getText());

                if (!(name.equals("") || email.equals("") || address.equals("") || phone.equals(""))){
                    //Αν όλα τα πεδία δεν είναι κενά

                    final Pelatis pelatis = new Pelatis(UUID.randomUUID().toString(), name, address, email, phone); // Δημιουργία πελάτη
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            db.pelatisDataAccessObject().insert(pelatis); // Εισαγωγή του καινούριου πελάτη στην βάση
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() { //Set όλα τα πεδία κενά
                                    newPelatisNameTxt.setText("");
                                    newPelatisEmailTxt.setText("");
                                    newPelatisAddressTxt.setText("");
                                    newPelatisPhoneTxt.setText("");
                                    Toast.makeText(getActivity(), "Ο πελάτης προστέθηκε επιτυχώς!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);  //Κλέισιμο του keyboard

                }else{
                    Toast.makeText(getActivity(), "Δεν συμπλήρωσες όλα τα πεδία!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        insertProion = getActivity().findViewById(R.id.insertProductBtn);
        insertProion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                //Όταν πατηθεί το κουμπί Προσθήκη Προϊόν

                newProionNameTxt = getActivity().findViewById(R.id.newProductNameTxt);
                newProionDescriptionTxt = getActivity().findViewById(R.id.newProductDesctriptionTxt);
                newProionPriceTxt = getActivity().findViewById(R.id.newProductPriceTxt);
                newProionQuantity = getActivity().findViewById(R.id.newProductQuantityTxt3);
                newProionType = getActivity().findViewById(R.id.newProionType);

                String name = String.valueOf(newProionNameTxt.getText());
                String description = String.valueOf(newProionDescriptionTxt.getText());
                Double price = Double.valueOf(String.valueOf(newProionPriceTxt.getText()));
                Integer quantity = Integer.valueOf(String.valueOf(newProionQuantity.getText()));

                int buttonId = newProionType.getCheckedRadioButtonId();
                int type = 0;
                radioButton = getActivity().findViewById(buttonId);

                if (radioButton.getText().equals("Laptop")) {               //Παίρνω την κατηγορία του καινούριου προϊόντως από το RadioButton που επιλέχθηκε
                    type = 1;
                }else if (radioButton.getText().equals("Smartphone")){
                    type = 2;
                }else if (radioButton.getText().equals("Smartwatch")){
                    type = 3;
                }else if (radioButton.getText().equals("Tablet")){
                    type = 4;
                }

                if(!(name.equals("") || description.equals("") || price == null ) || quantity == null || type == 0){
                    //Αν όλα τα πεδία δεν είναι κενά
                    final Proion proion = new Proion(UUID.randomUUID().toString(), name, description, price, quantity, type);
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            db.proionDataAccessObject().insert(proion); //Εισαγωγή προϊόντος στην βάση
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() { //Θέτω όλα τα πεδία κενά
                                    newProionNameTxt.setText("");
                                    newProionDescriptionTxt.setText("");
                                    newProionPriceTxt.setText("");
                                    newProionQuantity.setText("");
                                    newProionType.clearFocus();
                                    Toast.makeText(getActivity(), "Το προϊόν προστέθηκε επιτυχώς!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);//Κλείσιμο keyboard

                }else{
                    Toast.makeText(getActivity(), "Δεν συμπλήρωσες όλα τα πεδία!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
