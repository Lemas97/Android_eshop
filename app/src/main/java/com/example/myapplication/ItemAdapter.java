package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import Model.Product;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    public ItemAdapter(Context c, String[] names, String[] description, String[] price) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.names = names;
        this.description = description;
        this.price = price;
    }

    String[] names;
    String[] description;
    String[] price;



    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.list_custom_layout, null);
        TextView nameTextView = v.findViewById(R.id.product_name);
        TextView descriptionTextView = v.findViewById(R.id.product_description);
        TextView priceTextView = v.findViewById(R.id.product_price);

        nameTextView.setText(names[i]);
        descriptionTextView.setText(description[i]);
        priceTextView.setText(price[i]);

        return v;
    }
}
