package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import Model.Proion;
import db.AppDatabase;

public class CartFragment extends Fragment implements View.OnClickListener {


    private Button nextProcessBtn;
    private TextView txtTotalAmount;

    float totalPrice = 0;

    private final List<String> names = new ArrayList<>();
    private final List<String> descriptions = new ArrayList<>();
    private final List<Double> prices = new ArrayList<>();
    private final List<String> ids = new ArrayList<>();
    private final List<Proion> products = new ArrayList<>();
    private ListView listview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        final AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "eshop").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<String> productIds = db.kalathiDataAccessObject().findIds();

                for (int i = 0; i < productIds.size(); i++) {
                    String proionId = productIds.get(i);
                    Proion proion = db.proionDataAccessObject().findById(proionId);
                    String name = proion.getName();
                    String description = proion.getPerigrafi();
                    double cost = proion.getKostos();

                    ids.add(proionId);
                    products.add(proion);
                    names.add(name);
                    descriptions.add(description);
                    prices.add(cost);
                    totalPrice += prices.get(i);        //Υπολογισμός συνολικού ποσού
                }
                getActivity().runOnUiThread((new Runnable() {
                    @Override
                    public void run() {
                        listview = getActivity().findViewById(R.id.cart_list);
                        CartItemAdapter cartItemAdapter = new CartItemAdapter(CartFragment.this.getActivity(), names, descriptions, prices, ids); //,kalathi aporia
                        listview.setAdapter(cartItemAdapter);

                        TextView totalprices = getActivity().findViewById(R.id.total_price);
                        totalprices.setText("Συνολικό ποσό = " + String.valueOf(totalPrice));
                    }
                }));
            }
        });

        nextProcessBtn = getActivity().findViewById(R.id.next_process_btn);
        txtTotalAmount = getActivity().findViewById(R.id.total_price);
        nextProcessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ConfirmFinalOrderFragment()).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
