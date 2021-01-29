package com.example.myapplication.Adapters;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.room.Room;

import com.example.myapplication.R;

import java.util.List;

import Model.Kalathi;
import db.AppDatabase;

public class CartItemAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<String> names;
    private List<String> description;
    private List<Double> price;
    private List<String> id;


    public CartItemAdapter(Context c, List<String> names, List<String> description, List<Double> price, List<String> id) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Περνάω σε λίστες τα πεδία των προϊόντων
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

        nameTextView.setText(names.get(i));
        descriptionTextView.setText(description.get(i));
        priceTextView.setText(String.valueOf(price.get(i)));
        return v;   //Δημιουργία του Item της λίστας
    }
}
