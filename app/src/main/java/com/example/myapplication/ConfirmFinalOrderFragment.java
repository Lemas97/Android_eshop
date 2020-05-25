package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ConfirmFinalOrderFragment extends Fragment {

    private EditText nameEditText, phoneEditText, addressEditText, cityEditText, emailEditText;
    private Button confirmOrderBtn;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_details,container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        confirmOrderBtn = getActivity().findViewById(R.id.confirm_final_order_btn);
        nameEditText = getActivity().findViewById(R.id.shipment_name);
        phoneEditText = getActivity().findViewById(R.id.shipment_phone);
        addressEditText = getActivity().findViewById(R.id.shipment_home_address);
        cityEditText = getActivity().findViewById(R.id.shipment_city);
        emailEditText = getActivity().findViewById(R.id.shipment_email);

    }



    //    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//            confirmOrderBtn = findViewById(R.id.confirm_final_order_btn);
//            nameEditText = findViewById(R.id.shipment_name);
//            phoneEditText = findViewById(R.id.shipment_phone);
//            addressEditText = findViewById(R.id.shipment_home_address);
//            cityEditText = findViewById(R.id.shipment_city);
//            emailEditText = findViewById(R.id.shipment_email);
//
//
//    }
}