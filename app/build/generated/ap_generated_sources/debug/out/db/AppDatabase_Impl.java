package db;

import DataAccessObject.KalathiDataAccessObject;
import DataAccessObject.KalathiDataAccessObject_Impl;
import DataAccessObject.PelatisAccessObject;
import DataAccessObject.PelatisAccessObject_Impl;
import DataAccessObject.PolisiDataAccessObject;
import DataAccessObject.PolisiDataAccessObject_Impl;
import DataAccessObject.ProionDataAccessObject;
import DataAccessObject.ProionDataAccessObject_Impl;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class AppDatabase_Impl extends AppDatabase {
  private volatile PelatisAccessObject _pelatisAccessObject;

  private volatile ProionDataAccessObject _proionDataAccessObject;

  private volatile PolisiDataAccessObject _polisiDataAccessObject;

  private volatile KalathiDataAccessObject _kalathiDataAccessObject;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Pelatis` (`id` TEXT NOT NULL, `name` TEXT, `address` TEXT, `email` TEXT, `telephoneNumber` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Proion` (`id` TEXT NOT NULL, `name` TEXT, `perigrafi` TEXT, `kostos` REAL NOT NULL, `apothema` INTEGER NOT NULL, `type` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Polisi` (`id` TEXT NOT NULL, `proionId` TEXT, `pelatidId` TEXT, `posotita` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Kalathi` (`id` TEXT NOT NULL, `proionId` TEXT, `posotita` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"016f2fdea1a78a533fa0500520e2343a\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Pelatis`");
        _db.execSQL("DROP TABLE IF EXISTS `Proion`");
        _db.execSQL("DROP TABLE IF EXISTS `Polisi`");
        _db.execSQL("DROP TABLE IF EXISTS `Kalathi`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPelatis = new HashMap<String, TableInfo.Column>(5);
        _columnsPelatis.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsPelatis.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsPelatis.put("address", new TableInfo.Column("address", "TEXT", false, 0));
        _columnsPelatis.put("email", new TableInfo.Column("email", "TEXT", false, 0));
        _columnsPelatis.put("telephoneNumber", new TableInfo.Column("telephoneNumber", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPelatis = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPelatis = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPelatis = new TableInfo("Pelatis", _columnsPelatis, _foreignKeysPelatis, _indicesPelatis);
        final TableInfo _existingPelatis = TableInfo.read(_db, "Pelatis");
        if (! _infoPelatis.equals(_existingPelatis)) {
          throw new IllegalStateException("Migration didn't properly handle Pelatis(Model.Pelatis).\n"
                  + " Expected:\n" + _infoPelatis + "\n"
                  + " Found:\n" + _existingPelatis);
        }
        final HashMap<String, TableInfo.Column> _columnsProion = new HashMap<String, TableInfo.Column>(6);
        _columnsProion.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsProion.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsProion.put("perigrafi", new TableInfo.Column("perigrafi", "TEXT", false, 0));
        _columnsProion.put("kostos", new TableInfo.Column("kostos", "REAL", true, 0));
        _columnsProion.put("apothema", new TableInfo.Column("apothema", "INTEGER", true, 0));
        _columnsProion.put("type", new TableInfo.Column("type", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProion = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProion = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProion = new TableInfo("Proion", _columnsProion, _foreignKeysProion, _indicesProion);
        final TableInfo _existingProion = TableInfo.read(_db, "Proion");
        if (! _infoProion.equals(_existingProion)) {
          throw new IllegalStateException("Migration didn't properly handle Proion(Model.Proion).\n"
                  + " Expected:\n" + _infoProion + "\n"
                  + " Found:\n" + _existingProion);
        }
        final HashMap<String, TableInfo.Column> _columnsPolisi = new HashMap<String, TableInfo.Column>(4);
        _columnsPolisi.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsPolisi.put("proionId", new TableInfo.Column("proionId", "TEXT", false, 0));
        _columnsPolisi.put("pelatidId", new TableInfo.Column("pelatidId", "TEXT", false, 0));
        _columnsPolisi.put("posotita", new TableInfo.Column("posotita", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPolisi = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPolisi = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPolisi = new TableInfo("Polisi", _columnsPolisi, _foreignKeysPolisi, _indicesPolisi);
        final TableInfo _existingPolisi = TableInfo.read(_db, "Polisi");
        if (! _infoPolisi.equals(_existingPolisi)) {
          throw new IllegalStateException("Migration didn't properly handle Polisi(Model.Polisi).\n"
                  + " Expected:\n" + _infoPolisi + "\n"
                  + " Found:\n" + _existingPolisi);
        }
        final HashMap<String, TableInfo.Column> _columnsKalathi = new HashMap<String, TableInfo.Column>(3);
        _columnsKalathi.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsKalathi.put("proionId", new TableInfo.Column("proionId", "TEXT", false, 0));
        _columnsKalathi.put("posotita", new TableInfo.Column("posotita", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKalathi = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKalathi = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKalathi = new TableInfo("Kalathi", _columnsKalathi, _foreignKeysKalathi, _indicesKalathi);
        final TableInfo _existingKalathi = TableInfo.read(_db, "Kalathi");
        if (! _infoKalathi.equals(_existingKalathi)) {
          throw new IllegalStateException("Migration didn't properly handle Kalathi(Model.Kalathi).\n"
                  + " Expected:\n" + _infoKalathi + "\n"
                  + " Found:\n" + _existingKalathi);
        }
      }
    }, "016f2fdea1a78a533fa0500520e2343a", "b9b8980db3da457ea8a74975ec03a71f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Pelatis","Proion","Polisi","Kalathi");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Pelatis`");
      _db.execSQL("DELETE FROM `Proion`");
      _db.execSQL("DELETE FROM `Polisi`");
      _db.execSQL("DELETE FROM `Kalathi`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public PelatisAccessObject pelatisDataAccessObject() {
    if (_pelatisAccessObject != null) {
      return _pelatisAccessObject;
    } else {
      synchronized(this) {
        if(_pelatisAccessObject == null) {
          _pelatisAccessObject = new PelatisAccessObject_Impl(this);
        }
        return _pelatisAccessObject;
      }
    }
  }

  @Override
  public ProionDataAccessObject proionDataAccessObject() {
    if (_proionDataAccessObject != null) {
      return _proionDataAccessObject;
    } else {
      synchronized(this) {
        if(_proionDataAccessObject == null) {
          _proionDataAccessObject = new ProionDataAccessObject_Impl(this);
        }
        return _proionDataAccessObject;
      }
    }
  }

  @Override
  public PolisiDataAccessObject polisiDataAccessObject() {
    if (_polisiDataAccessObject != null) {
      return _polisiDataAccessObject;
    } else {
      synchronized(this) {
        if(_polisiDataAccessObject == null) {
          _polisiDataAccessObject = new PolisiDataAccessObject_Impl(this);
        }
        return _polisiDataAccessObject;
      }
    }
  }

  @Override
  public KalathiDataAccessObject kalathiDataAccessObject() {
    if (_kalathiDataAccessObject != null) {
      return _kalathiDataAccessObject;
    } else {
      synchronized(this) {
        if(_kalathiDataAccessObject == null) {
          _kalathiDataAccessObject = new KalathiDataAccessObject_Impl(this);
        }
        return _kalathiDataAccessObject;
      }
    }
  }
}
