package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.room.Room;

import java.util.List;
import java.util.UUID;

import Model.Kalathi;
import db.AppDatabase;

public class CartItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    Button deleteBtn;
    List<String> names;
    List<String> description;
    List<Double> price;
    List<String> id;



    public CartItemAdapter(Context c, List<String> names, List<String> description, List<Double> price, List<String> id) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.names = names;
        this.description = description;
        this.price = price;
        this.id = id;
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
        View v = mInflater.inflate(R.layout.list_cart_custom_layout, null);
        final TextView nameTextView = v.findViewById(R.id.product_name);
        TextView descriptionTextView = v.findViewById(R.id.product_description);
        TextView priceTextView = v.findViewById(R.id.product_price);

        final AppDatabase db = Room.databaseBuilder(mInflater.getContext(),
                AppDatabase.class, "eshop").build();

        nameTextView.setText(names.get(i));
        descriptionTextView.setText(description.get(i));
        priceTextView.setText(String.valueOf(price.get(i)));
        deleteBtn = v.findViewById(R.id.deleteFromCartBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                       
                    }
                });
            }
        });
        return v;
    }
}
