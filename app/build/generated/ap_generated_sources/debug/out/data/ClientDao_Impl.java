package data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ClientDao_Impl implements ClientDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Client> __insertionAdapterOfClient;

  private final EntityDeletionOrUpdateAdapter<Client> __deletionAdapterOfClient;

  public ClientDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClient = new EntityInsertionAdapter<Client>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `client_table` (`uid`,`prenom`,`nom`,`birthday`,`villeNaissance`,`departement`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Client value) {
        stmt.bindLong(1, value.uid);
        if (value.getPrenom() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPrenom());
        }
        if (value.getNom() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNom());
        }
        if (value.getBirthday() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBirthday());
        }
        if (value.getVilleNaissance() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getVilleNaissance());
        }
        if (value.getDepartement() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDepartement());
        }
      }
    };
    this.__deletionAdapterOfClient = new EntityDeletionOrUpdateAdapter<Client>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `client_table` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Client value) {
        stmt.bindLong(1, value.uid);
      }
    };
  }

  @Override
  public void insertAll(final Client... clients) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfClient.insert(clients);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final Client client) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfClient.insert(client);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Client client) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfClient.handle(client);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(final Client... clients) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfClient.handleMultiple(clients);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Client>> getAll() {
    final String _sql = "SELECT * FROM client_table ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"client_table"}, false, new Callable<List<Client>>() {
      @Override
      public List<Client> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfPrenom = CursorUtil.getColumnIndexOrThrow(_cursor, "prenom");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfBirthday = CursorUtil.getColumnIndexOrThrow(_cursor, "birthday");
          final int _cursorIndexOfVilleNaissance = CursorUtil.getColumnIndexOrThrow(_cursor, "villeNaissance");
          final int _cursorIndexOfDepartement = CursorUtil.getColumnIndexOrThrow(_cursor, "departement");
          final List<Client> _result = new ArrayList<Client>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Client _item;
            final String _tmpPrenom;
            if (_cursor.isNull(_cursorIndexOfPrenom)) {
              _tmpPrenom = null;
            } else {
              _tmpPrenom = _cursor.getString(_cursorIndexOfPrenom);
            }
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpBirthday;
            if (_cursor.isNull(_cursorIndexOfBirthday)) {
              _tmpBirthday = null;
            } else {
              _tmpBirthday = _cursor.getString(_cursorIndexOfBirthday);
            }
            final String _tmpVilleNaissance;
            if (_cursor.isNull(_cursorIndexOfVilleNaissance)) {
              _tmpVilleNaissance = null;
            } else {
              _tmpVilleNaissance = _cursor.getString(_cursorIndexOfVilleNaissance);
            }
            final String _tmpDepartement;
            if (_cursor.isNull(_cursorIndexOfDepartement)) {
              _tmpDepartement = null;
            } else {
              _tmpDepartement = _cursor.getString(_cursorIndexOfDepartement);
            }
            _item = new Client(_tmpPrenom,_tmpNom,_tmpBirthday,_tmpVilleNaissance,_tmpDepartement);
            _item.uid = _cursor.getInt(_cursorIndexOfUid);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Client>> loadAllByIds(final int[] userIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM client_table WHERE uid IN (");
    final int _inputSize = userIds.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : userIds) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"client_table"}, false, new Callable<List<Client>>() {
      @Override
      public List<Client> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfPrenom = CursorUtil.getColumnIndexOrThrow(_cursor, "prenom");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfBirthday = CursorUtil.getColumnIndexOrThrow(_cursor, "birthday");
          final int _cursorIndexOfVilleNaissance = CursorUtil.getColumnIndexOrThrow(_cursor, "villeNaissance");
          final int _cursorIndexOfDepartement = CursorUtil.getColumnIndexOrThrow(_cursor, "departement");
          final List<Client> _result = new ArrayList<Client>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Client _item_1;
            final String _tmpPrenom;
            if (_cursor.isNull(_cursorIndexOfPrenom)) {
              _tmpPrenom = null;
            } else {
              _tmpPrenom = _cursor.getString(_cursorIndexOfPrenom);
            }
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpBirthday;
            if (_cursor.isNull(_cursorIndexOfBirthday)) {
              _tmpBirthday = null;
            } else {
              _tmpBirthday = _cursor.getString(_cursorIndexOfBirthday);
            }
            final String _tmpVilleNaissance;
            if (_cursor.isNull(_cursorIndexOfVilleNaissance)) {
              _tmpVilleNaissance = null;
            } else {
              _tmpVilleNaissance = _cursor.getString(_cursorIndexOfVilleNaissance);
            }
            final String _tmpDepartement;
            if (_cursor.isNull(_cursorIndexOfDepartement)) {
              _tmpDepartement = null;
            } else {
              _tmpDepartement = _cursor.getString(_cursorIndexOfDepartement);
            }
            _item_1 = new Client(_tmpPrenom,_tmpNom,_tmpBirthday,_tmpVilleNaissance,_tmpDepartement);
            _item_1.uid = _cursor.getInt(_cursorIndexOfUid);
            _result.add(_item_1);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Client findByName(final String prenom, final String nom) {
    final String _sql = "SELECT * FROM client_table WHERE prenom LIKE ? AND nom LIKE ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (prenom == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, prenom);
    }
    _argIndex = 2;
    if (nom == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nom);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfPrenom = CursorUtil.getColumnIndexOrThrow(_cursor, "prenom");
      final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
      final int _cursorIndexOfBirthday = CursorUtil.getColumnIndexOrThrow(_cursor, "birthday");
      final int _cursorIndexOfVilleNaissance = CursorUtil.getColumnIndexOrThrow(_cursor, "villeNaissance");
      final int _cursorIndexOfDepartement = CursorUtil.getColumnIndexOrThrow(_cursor, "departement");
      final Client _result;
      if(_cursor.moveToFirst()) {
        final String _tmpPrenom;
        if (_cursor.isNull(_cursorIndexOfPrenom)) {
          _tmpPrenom = null;
        } else {
          _tmpPrenom = _cursor.getString(_cursorIndexOfPrenom);
        }
        final String _tmpNom;
        if (_cursor.isNull(_cursorIndexOfNom)) {
          _tmpNom = null;
        } else {
          _tmpNom = _cursor.getString(_cursorIndexOfNom);
        }
        final String _tmpBirthday;
        if (_cursor.isNull(_cursorIndexOfBirthday)) {
          _tmpBirthday = null;
        } else {
          _tmpBirthday = _cursor.getString(_cursorIndexOfBirthday);
        }
        final String _tmpVilleNaissance;
        if (_cursor.isNull(_cursorIndexOfVilleNaissance)) {
          _tmpVilleNaissance = null;
        } else {
          _tmpVilleNaissance = _cursor.getString(_cursorIndexOfVilleNaissance);
        }
        final String _tmpDepartement;
        if (_cursor.isNull(_cursorIndexOfDepartement)) {
          _tmpDepartement = null;
        } else {
          _tmpDepartement = _cursor.getString(_cursorIndexOfDepartement);
        }
        _result = new Client(_tmpPrenom,_tmpNom,_tmpBirthday,_tmpVilleNaissance,_tmpDepartement);
        _result.uid = _cursor.getInt(_cursorIndexOfUid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
