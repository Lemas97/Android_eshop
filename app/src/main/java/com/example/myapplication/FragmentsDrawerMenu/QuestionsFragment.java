package com.example.myapplication.FragmentsDrawerMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.FragmentsQuestions.KatastasiPelatwnFragment;
import com.example.myapplication.FragmentsQuestions.KatastasiProiontwnFragment;
import com.example.myapplication.FragmentsQuestions.PoliseisAnaProionFragment;
import com.example.myapplication.FragmentsQuestions.QuantitiesFragment;
import com.example.myapplication.FragmentsQuestions.SunolikesPoliseisFragment;
import com.example.myapplication.R;

public class QuestionsFragment extends Fragment implements View.OnClickListener {

    private Button quantityBtn,salesBtn,productSalesBtn,customersBtn,productsBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_questions,container, false);  //Αυτό το Fragment ανοίγει όταν επιλεχθεί το "Ερωτήσεις" από το Drawer Menu
    }

    @Override
    public void onStart() {
        super.onStart();

        quantityBtn = getActivity().findViewById(R.id.quantityBtn);
        quantityBtn.setOnClickListener(this);
        salesBtn = getActivity().findViewById(R.id.salesBtn);
        salesBtn.setOnClickListener(this);
        productSalesBtn = getActivity().findViewById(R.id.productSalesBtn);
        productSalesBtn.setOnClickListener(this);
        customersBtn = getActivity().findViewById(R.id.customersBtn);
        customersBtn.setOnClickListener(this);
        productsBtn = getActivity().findViewById(R.id.productsBtn);
        productsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){          //Ανοίγει το αντίστοιχο Fragment του κουμπιού
            case R.id.quantityBtn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QuantitiesFragment()).addToBackStack(null).commit();
                break;
            case R.id.salesBtn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SunolikesPoliseisFragment()).addToBackStack(null).commit();
                break;
            case R.id.productSalesBtn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PoliseisAnaProionFragment()).addToBackStack(null).commit();
                break;
            case R.id.customersBtn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new KatastasiPelatwnFragment()).addToBackStack(null).commit();
                break;
            case R.id.productsBtn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new KatastasiProiontwnFragment()).addToBackStack(null).commit();
                break;
        }

    }

}
