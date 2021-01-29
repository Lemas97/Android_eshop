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

public class KatastasiProiontwnAdapter extends BaseAdapter {
    private List<String> names = new ArrayList<>();
    private List<Integer> apothemata;
    private List<Double> prices;
    private LayoutInflater mInflater;

    public KatastasiProiontwnAdapter(Context c, List<String> names, List<Integer> apothemata, List<Double> prices) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //Το Fragment που βρίσκομαι εκείνη την στιγμή

        //Περνάω σε λίστες τα πεδία των πελατώ
        this.names = names;
        this.apothemata = apothemata;
        this.prices = prices;

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
    public View getView(final int i, View view, ViewGroup viewGroup) {  //Δημιουργείται δυναμικά η λίστα των Προϊόντων

        View v = mInflater.inflate(R.layout.list_katastasi_prionton_custom_layout, null);
        TextView namePelatisTxt = v.findViewById(R.id.nameProionTxt);
        TextView apothemaTxt = v.findViewById(R.id.apothemaTxt);
        TextView pricesTxt = v.findViewById(R.id.pricesTxt);

        namePelatisTxt.setText(names.get(i));
        apothemaTxt.setText(String.valueOf(apothemata.get(i)));
        pricesTxt.setText(String.valueOf(prices.get(i)));

        return v;
    }
}
