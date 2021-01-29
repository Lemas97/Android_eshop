package DataAccessObject;

import Model.Polisi;
import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class PolisiDataAccessObject_Impl implements PolisiDataAccessObject {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPolisi;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPolisi;

  public PolisiDataAccessObject_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPolisi = new EntityInsertionAdapter<Polisi>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Polisi`(`id`,`proionId`,`pelatidId`,`posotita`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Polisi value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getProionId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProionId());
        }
        if (value.getPelatisId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPelatisId());
        }
        stmt.bindLong(4, value.getPosotita());
      }
    };
    this.__deletionAdapterOfPolisi = new EntityDeletionOrUpdateAdapter<Polisi>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Polisi` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Polisi value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(Polisi polisi) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPolisi.insert(polisi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Polisi polisi) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPolisi.handle(polisi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Polisi findById(String polisiId) {
    final String _sql = "SELECT * FROM Polisi WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (polisiId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, polisiId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfProionId = _cursor.getColumnIndexOrThrow("proionId");
      final int _cursorIndexOfPelatisId = _cursor.getColumnIndexOrThrow("pelatidId");
      final int _cursorIndexOfPosotita = _cursor.getColumnIndexOrThrow("posotita");
      final Polisi _result;
      if(_cursor.moveToFirst()) {
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpProionId;
        _tmpProionId = _cursor.getString(_cursorIndexOfProionId);
        final String _tmpPelatisId;
        _tmpPelatisId = _cursor.getString(_cursorIndexOfPelatisId);
        final int _tmpPosotita;
        _tmpPosotita = _cursor.getInt(_cursorIndexOfPosotita);
        _result = new Polisi(_tmpId,_tmpProionId,_tmpPelatisId,_tmpPosotita);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Polisi> findByProductId(String proionId) {
    final String _sql = "SELECT * FROM Polisi WHERE proionId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (proionId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, proionId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfProionId = _cursor.getColumnIndexOrThrow("proionId");
      final int _cursorIndexOfPelatisId = _cursor.getColumnIndexOrThrow("pelatidId");
      final int _cursorIndexOfPosotita = _cursor.getColumnIndexOrThrow("posotita");
      final List<Polisi> _result = new ArrayList<Polisi>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Polisi _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpProionId;
        _tmpProionId = _cursor.getString(_cursorIndexOfProionId);
        final String _tmpPelatisId;
        _tmpPelatisId = _cursor.getString(_cursorIndexOfPelatisId);
        final int _tmpPosotita;
        _tmpPosotita = _cursor.getInt(_cursorIndexOfPosotita);
        _item = new Polisi(_tmpId,_tmpProionId,_tmpPelatisId,_tmpPosotita);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Polisi> findAll() {
    final String _sql = "SELECT * FROM Polisi";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfProionId = _cursor.getColumnIndexOrThrow("proionId");
      final int _cursorIndexOfPelatisId = _cursor.getColumnIndexOrThrow("pelatidId");
      final int _cursorIndexOfPosotita = _cursor.getColumnIndexOrThrow("posotita");
      final List<Polisi> _result = new ArrayList<Polisi>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Polisi _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpProionId;
        _tmpProionId = _cursor.getString(_cursorIndexOfProionId);
        final String _tmpPelatisId;
        _tmpPelatisId = _cursor.getString(_cursorIndexOfPelatisId);
        final int _tmpPosotita;
        _tmpPosotita = _cursor.getInt(_cursorIndexOfPosotita);
        _item = new Polisi(_tmpId,_tmpProionId,_tmpPelatisId,_tmpPosotita);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
