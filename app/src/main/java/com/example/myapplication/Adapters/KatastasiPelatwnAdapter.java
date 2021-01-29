package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class KatastasiPelatwnAdapter extends BaseAdapter {
    private List<String> names = new ArrayList<>();
    private List<String> emails;
    private List<String> phones;
    private List<String> address;
    private LayoutInflater mInflater;


    public KatastasiPelatwnAdapter(Context c, List<String> names, List<String> emails, List<String> phones, List<String> address) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Περνάω σε λίστες τα πεδία των πελατών
        this.names = names;
        this.emails = emails;
        this.phones = phones;
        this.address = address;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {  //Δημιουργείται δυναμικά η λίστα των πελατών

        View v = mInflater.inflate(R.layout.list_katastasi_pelatwn_custom_layout, null);
        TextView namePelatisTxt = v.findViewById(R.id.namePelatesTxt);
        TextView emailPelatisTxt = v.findViewById(R.id.emailTxt);
        TextView tilefonoTxt = v.findViewById(R.id.tilefonoTxt);
        TextView addressTxt = v.findViewById(R.id.addressPelatesTxt);


        namePelatisTxt.setText(names.get(i));
        emailPelatisTxt.setText(emails.get(i));
        tilefonoTxt.setText(phones.get(i));
        addressTxt.setText(address.get(i));

        return v;
    }
}
