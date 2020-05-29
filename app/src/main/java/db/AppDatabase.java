package db;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import DataAccessObject.KalathiDataAccessObject;
import DataAccessObject.PelatisAccessObject;
import DataAccessObject.PolisiDataAccessObject;
import DataAccessObject.ProionDataAccessObject;
import Model.Kalathi;
import Model.Pelatis;
import Model.Proion;

import Model.Polisi;

@Database(entities = {Pelatis.class, Proion.class, Polisi.class, Kalathi.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PelatisAccessObject pelatisDataAccessObject();
    public abstract ProionDataAccessObject proionDataAccessObject();
    public abstract PolisiDataAccessObject polisiDataAccessObject();
    public abstract KalathiDataAccessObject kalathiDataAccessObject();
}
