package DataAccessObject;

import Model.Pelatis;
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
public final class PelatisAccessObject_Impl implements PelatisAccessObject {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPelatis;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPelatis;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public PelatisAccessObject_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPelatis = new EntityInsertionAdapter<Pelatis>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Pelatis`(`id`,`name`,`address`,`email`,`telephoneNumber`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pelatis value) {
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
        if (value.getDiefthinsi() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDiefthinsi());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEmail());
        }
        if (value.getTilifono() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTilifono());
        }
      }
    };
    this.__deletionAdapterOfPelatis = new EntityDeletionOrUpdateAdapter<Pelatis>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Pelatis` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pelatis value) {
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
        final String _query = "Update Pelatis set name=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(Pelatis pelatis) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPelatis.insert(pelatis);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Pelatis customer) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPelatis.handle(customer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(String name) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (name == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, name);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public Pelatis findById(String pelatisId) {
    final String _sql = "SELECT * FROM Pelatis WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (pelatisId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pelatisId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfDiefthinsi = _cursor.getColumnIndexOrThrow("address");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfTilifono = _cursor.getColumnIndexOrThrow("telephoneNumber");
      final Pelatis _result;
      if(_cursor.moveToFirst()) {
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpDiefthinsi;
        _tmpDiefthinsi = _cursor.getString(_cursorIndexOfDiefthinsi);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpTilifono;
        _tmpTilifono = _cursor.getString(_cursorIndexOfTilifono);
        _result = new Pelatis(_tmpId,_tmpName,_tmpDiefthinsi,_tmpEmail,_tmpTilifono);
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
  public List<Pelatis> findAll() {
    final String _sql = "SELECT * FROM Pelatis";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfDiefthinsi = _cursor.getColumnIndexOrThrow("address");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfTilifono = _cursor.getColumnIndexOrThrow("telephoneNumber");
      final List<Pelatis> _result = new ArrayList<Pelatis>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Pelatis _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpDiefthinsi;
        _tmpDiefthinsi = _cursor.getString(_cursorIndexOfDiefthinsi);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpTilifono;
        _tmpTilifono = _cursor.getString(_cursorIndexOfTilifono);
        _item = new Pelatis(_tmpId,_tmpName,_tmpDiefthinsi,_tmpEmail,_tmpTilifono);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
