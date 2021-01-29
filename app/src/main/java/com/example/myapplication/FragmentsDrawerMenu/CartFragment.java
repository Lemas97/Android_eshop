package com.example.myapplication.FragmentsDrawerMenu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.myapplication.Adapters.CartItemAdapter;
import com.example.myapplication.ConfirmFinalOrderFragment;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Model.Kalathi;
import Model.Proion;
import db.AppDatabase;

public class CartFragment extends Fragment {


    private Button nextProcessBtn;
    private TextView txtTotalAmount;

    float totalPrice = 0;

    private final List<String> names = new ArrayList<>();
    private final List<String> descriptions = new ArrayList<>();
    private final List<Double> prices = new ArrayList<>();
    private final List<String> ids = new ArrayList<>();
    private final List<Proion> products = new ArrayList<>();
    private ListView listview;
    private Button clearBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        final AppDatabase db = Room.databaseBuilder(getActivity(),                                  // Θέτω το db ώστε να έχω πρόσβαση στην βάση
                AppDatabase.class, "eshop").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {                                                                    // Κάθε φορά που χρησιμοποιώ την βάση ανοίξει το Async Task ώστε να τρέξει σε άλλο Thread
                                                                                                    // και να μην εμποδίσει το UI

                List<String> productIds = db.kalathiDataAccessObject().findIds();                   //Παίρνω τα ids των προϊόντων από τον πίνακα καλάθι της βάση

                for (int i = 0; i < productIds.size(); i++) {                                       //Με βάση τα ids των προϊόντων του καλαθιού παίρνω
                    String proionId = productIds.get(i);
                    Proion proion = db.proionDataAccessObject().findById(proionId);                 //παίρνω τα προϊόντα του καλαθιού
                    String name = proion.getName();
                    String description = proion.getPerigrafi();
                    double cost = proion.getKostos();

                    ids.add(proionId);                                                              //και περνάω τα πεδία του σε λίστες
                    products.add(proion);
                    names.add(name);
                    descriptions.add(description);
                    prices.add(cost);
                    totalPrice += prices.get(i);        //Υπολογισμός συνολικού κόστους
                }
                getActivity().runOnUiThread((new Runnable() {
                    @Override
                    public void run() {
                        listview = getActivity().findViewById(R.id.cart_list);
                        CartItemAdapter cartItemAdapter = new CartItemAdapter(CartFragment.this.getActivity(), names, descriptions, prices, ids); // Στέλνω τις λίστες στον CartItemAdapter
                        listview.setAdapter(cartItemAdapter);                                                                                     // ώστεν να εμφανιστούν στο ListView του cart

                        TextView totalprices = getActivity().findViewById(R.id.total_price);
                        totalprices.setText("Συνολικό ποσό = " + String.valueOf(totalPrice));       //Εμφανίζω το συνολικό πόσό στο TextView totalPrice
                    }
                }));
            }
        });

        nextProcessBtn = getActivity().findViewById(R.id.next_process_btn);
        txtTotalAmount = getActivity().findViewById(R.id.total_price);
        nextProcessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                                //Όταν πατηθεί το κουμπί nextProcess ανοίγει το Fragment ConfirmFinalOrder
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,            //ώστε ο πελάτης να βάλει τα στοιχεία του
                        new ConfirmFinalOrderFragment()).addToBackStack(null).commit();
            }
        });

        clearBtn = getActivity().findViewById(R.id.clearCartBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                                      // Όταν πατηθεί του κουμπί Clear Cart
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        List<Kalathi> kalathia = db.kalathiDataAccessObject().findAll();
                        for (Kalathi kalathi:kalathia) {
                            db.kalathiDataAccessObject().delete(kalathi);                           //Σβήνει όλα τα καλάθια από την βάση
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(), "Το καλάθι διαφράφηκε!", Toast.LENGTH_LONG).show();
                                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                            new ShopFragment()).addToBackStack(null).commit();      //και σε πετάει στην σελίδα Shop
                                }
                            });                                                                     //γιατί δεν βρήκα τρόπο να κάνω Refresh/Reload το Fragment από τον CardItemAdapter
                        }                                                                           //είτε να κάνω update/delete τα items της λίστας
                    }
                });
            }
        });
    }
}
