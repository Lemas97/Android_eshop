package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Model.Kalathi;
import db.AppDatabase;

public class ItemAdapter extends BaseAdapter {
    private List<String> names = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();
    private List<Double> prices = new ArrayList<>();
    private List<String> ids = new ArrayList<>();
    private List<Integer> itemQuantities = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private LayoutInflater mInflater;
    private Button addToCart;
    private String selectedId;
    private TextView apothemaTxt;

    public ItemAdapter(Context c, List<String> names, List<String> description, List<Double> price, List<String> id, List<Integer> quantity) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.names = names;
        this.descriptions = description;
        this.prices = price;
        this.ids = id;
        this.quantities = quantity;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        return names.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.list_custom_layout, null);
        final TextView nameTextView = v.findViewById(R.id.product_name);
        TextView descriptionTextView = v.findViewById(R.id.product_description);
        TextView priceTextView = v.findViewById(R.id.product_price);
        apothemaTxt = v.findViewById(R.id.apothemaTxt);

        for (int i2 = 0; i2 < names.size(); i2++) {
            this.itemQuantities.add(1);
        }
        final AppDatabase db = Room.databaseBuilder(mInflater.getContext(),
                AppDatabase.class, "eshop").build();

        apothemaTxt.setText("Απομένουν: " + quantities.get(i));
        nameTextView.setText(names.get(i));
        descriptionTextView.setText(descriptions.get(i));
        priceTextView.setText(String.valueOf(prices.get(i)));

        addToCart = v.findViewById(R.id.addToCartBtn);


        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedId = ids.get(i);

                if (quantities.get(i) > 0) {
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            db.kalathiDataAccessObject().insert(new Kalathi(UUID.randomUUID().toString(), selectedId, 1));

                        }
                    });
                } else {
                    Toast.makeText(mInflater.getContext(), "Δεν υπάρχει απόθεμα.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}
