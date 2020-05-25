package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.product_type_ui.LaptopFragment;
import com.example.myapplication.product_type_ui.SmartphoneFragment;
import com.example.myapplication.product_type_ui.SmartwatchFragment;
import com.example.myapplication.product_type_ui.TabletFragment;

public class ShopFragment extends Fragment implements View.OnClickListener {

    private CardView laptopCard, smartphoneCard, smartwatchCard, tabletCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_shop,container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // defining  Cards
        laptopCard = getActivity().findViewById(R.id.card_laptop);
        smartphoneCard = getActivity().findViewById(R.id.card_smartphone);
        smartwatchCard = getActivity().findViewById(R.id.card_smartwatch);
        tabletCard = getActivity().findViewById(R.id.card_tablet);

        // Add click listener to the cards
        laptopCard.setOnClickListener(this);
        smartphoneCard.setOnClickListener(this);
        smartwatchCard.setOnClickListener(this);
        tabletCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.card_laptop:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LaptopFragment()).addToBackStack(null).commit();   /*Εμφάνιση του Fragment και τοποθέτησή του στο backstack
                                                                                ώστε με το πάτημα του κουμπιού back να επιστρέφει στο αμέσως
                                                                                προηγούμενο fragment*/
                break;
            case R.id.card_smartphone:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SmartphoneFragment()).addToBackStack(null).commit();
                break;
            case R.id.card_smartwatch:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SmartwatchFragment()).addToBackStack(null).commit();
                break;
            case R.id.card_tablet:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TabletFragment()).addToBackStack(null).commit();
                break;
            default: break;
        }

    }


}
