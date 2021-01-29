package DataAccessObject;

import Model.Proion;
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
public final class ProionDataAccessObject_Impl implements ProionDataAccessObject {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProion;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfProion;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public ProionDataAccessObject_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProion = new EntityInsertionAdapter<Proion>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Proion`(`id`,`name`,`perigrafi`,`kostos`,`apothema`,`type`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Proion value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getPerigrafi() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPerigrafi());
        }
        stmt.bindDouble(4, value.getKostos());
        stmt.bindLong(5, value.getApothema());
        stmt.bindLong(6, value.getType());
      }
    };
    this.__deletionAdapterOfProion = new EntityDeletionOrUpdateAdapter<Proion>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Proion` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Proion value) {
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
        final String _query = "Update Proion set apothema=? where id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(Proion proion) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfProion.insert(proion);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Proion proion) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfProion.handle(proion);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(String id, int apothema) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, apothema);
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
  public Proion findById(String proionId) {
    final String _sql = "SELECT * FROM Proion WHERE id=?";
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
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfPerigrafi = _cursor.getColumnIndexOrThrow("perigrafi");
      final int _cursorIndexOfKostos = _cursor.getColumnIndexOrThrow("kostos");
      final int _cursorIndexOfApothema = _cursor.getColumnIndexOrThrow("apothema");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final Proion _result;
      if(_cursor.moveToFirst()) {
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpPerigrafi;
        _tmpPerigrafi = _cursor.getString(_cursorIndexOfPerigrafi);
        final double _tmpKostos;
        _tmpKostos = _cursor.getDouble(_cursorIndexOfKostos);
        final int _tmpApothema;
        _tmpApothema = _cursor.getInt(_cursorIndexOfApothema);
        final int _tmpType;
        _tmpType = _cursor.getInt(_cursorIndexOfType);
        _result = new Proion(_tmpId,_tmpName,_tmpPerigrafi,_tmpKostos,_tmpApothema,_tmpType);
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
  public List<Proion> findAll() {
    final String _sql = "SELECT * FROM Proion";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfPerigrafi = _cursor.getColumnIndexOrThrow("perigrafi");
      final int _cursorIndexOfKostos = _cursor.getColumnIndexOrThrow("kostos");
      final int _cursorIndexOfApothema = _cursor.getColumnIndexOrThrow("apothema");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final List<Proion> _result = new ArrayList<Proion>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Proion _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpPerigrafi;
        _tmpPerigrafi = _cursor.getString(_cursorIndexOfPerigrafi);
        final double _tmpKostos;
        _tmpKostos = _cursor.getDouble(_cursorIndexOfKostos);
        final int _tmpApothema;
        _tmpApothema = _cursor.getInt(_cursorIndexOfApothema);
        final int _tmpType;
        _tmpType = _cursor.getInt(_cursorIndexOfType);
        _item = new Proion(_tmpId,_tmpName,_tmpPerigrafi,_tmpKostos,_tmpApothema,_tmpType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
