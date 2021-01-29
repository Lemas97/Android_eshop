package DataAccessObject;

import Model.Kalathi;
import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class KalathiDataAccessObject_Impl implements KalathiDataAccessObject {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfKalathi;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfKalathi;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public KalathiDataAccessObject_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKalathi = new EntityInsertionAdapter<Kalathi>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Kalathi`(`id`,`proionId`,`posotita`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Kalathi value) {
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
        stmt.bindLong(3, value.getPosotita());
      }
    };
    this.__deletionAdapterOfKalathi = new EntityDeletionOrUpdateAdapter<Kalathi>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Kalathi` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Kalathi value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update kalathi set posotita = ? where id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(Kalathi kalathi) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfKalathi.insert(kalathi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Kalathi kalathi) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfKalathi.handle(kalathi);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(String id, int posotita) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, posotita);
      _argIndex = 2;
      if (id == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, id);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public List<Kalathi> findAll() {
    final String _sql = "SELECT * FROM Kalathi";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfProionId = _cursor.getColumnIndexOrThrow("proionId");
      final int _cursorIndexOfPosotita = _cursor.getColumnIndexOrThrow("posotita");
      final List<Kalathi> _result = new ArrayList<Kalathi>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Kalathi _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpProionId;
        _tmpProionId = _cursor.getString(_cursorIndexOfProionId);
        final int _tmpPosotita;
        _tmpPosotita = _cursor.getInt(_cursorIndexOfPosotita);
        _item = new Kalathi(_tmpId,_tmpProionId,_tmpPosotita);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> findIds() {
    final String _sql = "SELECT proionId FROM Kalathi";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
