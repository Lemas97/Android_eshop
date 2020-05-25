package com.example.myapplication.product_type_ui;

import android.content.ClipData;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.ItemAdapter;
import com.example.myapplication.R;

public class LaptopFragment extends Fragment {
    ListView listview;

    String[] names = {"laptop1","laptop2"};
    String[] description = {"hi1","hi2"};
    String[] price = {"700","90"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_laptop,container, false);
    }


    @Override
    public void onStart() {
        super.onStart();

        listview = getActivity().findViewById(R.id.laptoplist);
        Resources res = getResources();


        ItemAdapter itemAdapter = new ItemAdapter(getActivity(),names,description,price);
        listview.setAdapter(itemAdapter);
    }
}
