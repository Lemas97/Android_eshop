package com.example.myapplication.Adapters;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.room.Room;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Model.Kalathi;
import db.AppDatabase;

public class QuantityAdapter extends BaseAdapter {
    private List<String> names = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private LayoutInflater mInflater;
    private TextView apothemaTxt;

    public QuantityAdapter(Context c, List<String> names , List<Integer> quantity) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Περνάω σε λίστες τα πεδία των προϊόντων που χρειάζονται που είναι στις πωλήσεις
        this.names = names;
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
    public View getView(final int i, View view, ViewGroup viewGroup) { //Δημιουργείται δυναμικά η λίστα των αποθεμάτων κάθε προϊόντος

        View v = mInflater.inflate(R.layout.list_quantities_custom_layout, null);
        TextView nameTextView = v.findViewById(R.id.productQuantityNameTxt);
        apothemaTxt = v.findViewById(R.id.quantityTxt);
        nameTextView.setText(names.get(i));
        apothemaTxt.setText("Απομένουν " + quantities.get(i));
        return v;
    }
}
