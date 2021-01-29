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

public class ItemAdapter extends BaseAdapter {
    private List<String> names = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();
    private List<Double> prices = new ArrayList<>();
    private List<String> ids = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private LayoutInflater mInflater;
    private Button addToCart;
    private String selectedId;
    private TextView apothemaTxt;

    /* Ο ItemAdapter εμφανίζει τα προϊόντα στην λίστα της κατηγορίας που επιλέχθηκε (Laptop/Smartphone/SmartWatch/Tablet)
    από το ShopFragment. Ουσιαστικά δημιουργεί δυναμικά
    */
    public ItemAdapter(Context c, List<String> names, List<String> description, List<Double> price, List<String> id, List<Integer> quantity) {
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);      //Ο mInflater παίρνει το Activity που ήμασταν (Laptop/Smartphone/SmartWatch/Tablet)

        //Περνάω σε λίστες τα πεδία των προϊόντων
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

        View v = mInflater.inflate(R.layout.list_custom_layout, null);                        //Το list_custom_layout είναι το layout του κάθε item/product.
        final TextView nameTextView = v.findViewById(R.id.product_name);
        TextView descriptionTextView = v.findViewById(R.id.product_description);
        TextView priceTextView = v.findViewById(R.id.product_price);
        apothemaTxt = v.findViewById(R.id.apothemaTxt);

        final AppDatabase db = Room.databaseBuilder(mInflater.getContext(),
                AppDatabase.class, "eshop").build();

        apothemaTxt.setText("Απομένουν: " + quantities.get(i));                                     //Θέτω κείμενο το TextView που δείχνει το απόθεμα
        nameTextView.setText(names.get(i));                                                         //Θέτω κείμενο το TextView που δείχνει το όνομα του προϊόντος
        descriptionTextView.setText(descriptions.get(i));                                           //Θέτω κείμενο το TextView που δείχνει την περιγραφή
        priceTextView.setText(String.valueOf(prices.get(i)));                                       //Θέτω κείμενο το TextView που δείχνει την τιμή

        addToCart = v.findViewById(R.id.addToCartBtn);
        addToCart.setOnClickListener(new View.OnClickListener() {                                   //Μόλις πατηθεί το κουμπί Add to cart
            @Override
            public void onClick(View view) {
                selectedId = ids.get(i);                                                            //Παίρνω το id του προϊόν στην θέση i της λίστας

                if (quantities.get(i) > 0) {                                                        //Αν το απόθεμα είναι μεγαλύτερο του 0, προσθήκη στο καλάθι
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            Kalathi kalathi = new Kalathi(UUID.randomUUID().toString(), selectedId, 1); // Το καλάθι παίρνει το id του προϊόν που επέλεξε ο πελάτης

                            db.kalathiDataAccessObject().insert(kalathi);   //Πέρασμα του καλαθιού στην βάση
                        }
                    });
                } else {
                    Toast.makeText(mInflater.getContext(), "Δεν υπάρχει απόθεμα.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v; //Δημιουργία του Item της λίστας
    }
}
