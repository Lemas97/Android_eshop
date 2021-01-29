package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PoliseisAnaProionAdapter extends BaseAdapter {
    private List<String> names = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private LayoutInflater mInflater;

    private TextView apothemaTxt;

    public PoliseisAnaProionAdapter(Context c, List<String> names , List<Integer> quantity) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) { //Δημιουργείται δυναμικά η λίστα των πωλήσεων ανά προϊόν

        View v = mInflater.inflate(R.layout.list_quantities_custom_layout, null);
        TextView nameTextView = v.findViewById(R.id.productQuantityNameTxt);
        apothemaTxt = v.findViewById(R.id.quantityTxt);

        apothemaTxt.setText("Πουλήθηκαν: " + quantities.get(i));
        nameTextView.setText(names.get(i));
        return v;
    }
}
