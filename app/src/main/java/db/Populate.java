package db;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import Model.Pelatis;
import Model.Polisi;
import Model.Proion;

public class Populate extends AppCompatActivity {
    private static final String DATABASE_NAME = "eshop";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, DATABASE_NAME).build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Pelatis> pelatis = new ArrayList<>();
                List<Proion> proion = new ArrayList<>();
                List<Polisi> polisi = new ArrayList<>();

                // ΔΗΜΙΟΥΡΓΙΑ ΛΙΣΤΑΣ ΠΕΛΑΤΩΝ
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Romana Jenkins", "993 West Westminster Rd.Oklahoma City, OK 73104", "oxohuhe-1348@yopmail.com", "(212) 778-3666"));
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Kareem Gill", "7783 Randall Mill Dr. Oklahoma City, OK 73149", "iderrossett-8835@yopmail.com", "(421) 521-0034"));
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Barbara Bowers", "212 3rd Dr. Marcus Hook, PA 19061","affammewy-8595@yopmail.com","(977) 277-4122"));
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Beth Deacon", "83 East Studebaker Dr. Edmond, OK 73003","selofoppyly-4377@yopmail.com","(954) 404-4504"));
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Mac Nixon", "9544 Lake Ave. Oklahoma City, OK 73142","niffytuffa-2497@yopmail.com", "(835) 746-8081"));
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Stanley Thorne", "77 Belmont Dr. Oklahoma City, OK 73103","bykovaball-1236@yopmail.com","(986) 813-1942"));
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Hughie Chamberlain", "805 Saxton Avenue Oklahoma City, OK 73121","jippinnejuv-2919@yopmail.com","(707) 662-6221"));
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Jethro Mckeown", "8053 Primrose Lane Edmond, OK 73012","udivetim-0472@yopmail.com","(613) 593-1169"));
                pelatis.add(new Pelatis(UUID.randomUUID().toString(), "Anisa Winters", "250 Pilgrim Street Oklahoma City, OK 73105","sirrannonnor-9743@yopmail.com","(279) 260-8379"));

                // ΔΗΜΙΟΥΡΓΙΑ ΛΙΣΤΑΣ ΠΡΟΙΟΝΤΩΝ
                proion.add(new Proion(UUID.randomUUID().toString(), "Huawei MateBook D 14", "Το Huawei MateBook D 14 είναι εξοπλισμένο με μια IPS FullView οθόνη 1920 x 1080, με λεπτό πλαίσιο μόλις 4.8 χιλιοστά", 619.80, 23, 1));
                proion.add(new Proion(UUID.randomUUID().toString(), "Apple MacBook Pro 15.4\"", "Ultrabook, 15.4\" IPS Panel 2880x1800, CPU: Intel Core i9 2.3GHz, RAM: 16GB, 512GB SSD, macOS, Κατασκευαστής: Apple.", 2584, 8, 1));
                proion.add(new Proion(UUID.randomUUID().toString(), "Lenovo IdeaPad L340-17IRH", "Gaming, 17.3\" IPS Panel 1920x1080, CPU: Intel Core i5 2.4GHz, RAM: 8GB, 512GB SSD, No OS, Κατασκευαστής: Lenovo", 399.00, 32, 1));
                proion.add(new Proion(UUID.randomUUID().toString(), "Xiaomi Redmi Note 8 (64GB) Neptune Blue", "Τετραπλή κάμερα με φακό 48MP, επεξεργαστής Snapdragon 665 και μπαταρία 4000mAh", 150.00, 15,2));
                proion.add(new Proion(UUID.randomUUID().toString(), "Apple iPhone 11 (64GB) Black", "Οθόνη: 6.1\", RAM: 4GB, Επεξεργαστής: Apple A13, Κάμερα: 12MP + 12MP, Selfie: 12MP, Μπαταρία: 3110mAh", 679.00, 9,2));
                proion.add(new Proion(UUID.randomUUID().toString(), "Samsung Galaxy A51 (128GB) Prism Crush Black", "Οθόνη: 6.5\", RAM: 4GB, Επεξεργαστής: Exynos 9611, Κάμερα: 48MP + 12MP + 5MP, Selfie: 32MP, Μπαταρία: 4000mAh", 264, 24,2));
                proion.add(new Proion(UUID.randomUUID().toString(), "Apple iPad 2019 10.2\" WiFi (32GB) Space Gray", "Οθόνη: 10.2\" 2160 x 1620 pixels, CPU: 2.34GHz Quad-Core, RAM: 3GB, Μνήμη Αποθήκευσης: 32GB, Δίκτυο: Wi-Fi, Λειτουργικό: iPadOS, Βάρος: 483gr", 334, 27,3));
                proion.add(new Proion(UUID.randomUUID().toString(), "Samsung Galaxy Tab A (2019) 10.1\" 4G (32GB) Black", "Οθόνη: 10.1\" 1920 x 1200 pixels, CPU: 1.6GHz Octa-Core, RAM: 2GB, Μνήμη Αποθήκευσης: 32GB, Δίκτυο: 4G - LTE, Λειτουργικό: Android, Βάρος: 469gr", 214.74, 18,3));
                proion.add(new Proion(UUID.randomUUID().toString(), "Huawei MediaPad T5 10.1\" (32GB) Black", "Οθόνη: 10.1\" 1920 x 1200 pixels, CPU: 2.36GHz Octa-Core (4+4), RAM: 3GB, Μνήμη Αποθήκευσης: 32GB, Δίκτυο: Wi-Fi, Λειτουργικό: Android, Βάρος: 460gr", 169.02, 34,3));
                proion.add(new Proion(UUID.randomUUID().toString(), "Xiaomi Amazfit Bip (Black)", "Οθόνη: 1.28\", 176x176 pixels, Βάρος: 40gr, Μέγεθος: 39mm",  48.45, 37,4));
                proion.add(new Proion(UUID.randomUUID().toString(), "Huawei Watch GT (Black)", "Οθόνη: 1.39\", 454x454 pixels, Βάρος: 46gr, Μέγεθος: 46mm", 86.71, 16,4));
                proion.add(new Proion(UUID.randomUUID().toString(), "Samsung Galaxy Watch 46mm", "Οθόνη: 1.3\", 360x360 pixels, Βάρος: 63gr, Μέγεθος: 46mm", 187.40, 26,4));

                //ΔΗΜΙΟΥΡΓΙΑ ΠΩΛΗΣΕΩΝ
                polisi.add(Polisi.create(proion.get(0).getId(), pelatis.get(0).getId(), 3));
                polisi.add(Polisi.create(proion.get(1).getId(), pelatis.get(1).getId(), 1));
                polisi.add(Polisi.create(proion.get(2).getId(), pelatis.get(2).getId(), 20));
                polisi.add(Polisi.create(proion.get(2).getId(), pelatis.get(2).getId(), 5));
                polisi.add(Polisi.create(proion.get(3).getId(), pelatis.get(3).getId(), 61));
                polisi.add(Polisi.create(proion.get(4).getId(), pelatis.get(4).getId(), 22));

                // Εισαγωγή των λιστών στην βάση
                Populate.this.pelatisPopulate(db, pelatis);
                Populate.this.proionPopulate(db, proion);
                Populate.this.polisiPopulate(db, polisi);

                Populate.this.finish();
            }
        });
    }
    private void pelatisPopulate(AppDatabase db, List<Pelatis> customers) {
        for (Pelatis customer : customers) {
            db.pelatisDataAccessObject().insert(customer);
        }
    }

    private void polisiPopulate(AppDatabase db, List<Polisi> sales) {
        for (Polisi sale : sales) {
            db.polisiDataAccessObject().insert(sale);
        }
    }

    private void proionPopulate(AppDatabase db, List<Proion> products) {
        for (Proion product : products) {
            db.proionDataAccessObject().insert(product);
        }
    }
}
