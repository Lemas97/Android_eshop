package com.example.myapplication.product_type_ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.ItemAdapter;
import com.example.myapplication.R;

public class SmartwatchFragment extends Fragment {

    ListView listView;

    String[] names = {"smartwatch1","smartwatch2"};
    String[] description = {"hi1","hi2"};
    String[] price = {"700","90"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_smartwatches,container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        listView = getActivity().findViewById(R.id.smartwachtlist);
        Resources res = getResources();


        ItemAdapter itemAdapter = new ItemAdapter(getActivity(),names,description,price);
        listView.setAdapter(itemAdapter);
    }
}
