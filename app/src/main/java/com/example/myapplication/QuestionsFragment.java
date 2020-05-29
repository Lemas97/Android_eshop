package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionsFragment extends Fragment implements View.OnClickListener {

    private Button quantityBtn,salesBtn,productSalesBtn,customersBtn,productsBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_questions,container, false);
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
        switch (view.getId()){
            case R.id.quantityBtn:

                break;
            case R.id.salesBtn:

                break;
            case R.id.productSalesBtn:

                break;
            case R.id.customersBtn:

                break;
            case R.id.productsBtn:

                break;
        }

    }

}
