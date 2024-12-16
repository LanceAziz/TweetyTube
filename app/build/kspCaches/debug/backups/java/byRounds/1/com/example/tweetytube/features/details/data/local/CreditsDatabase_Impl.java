package com.example.tweetytube.features.details.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CreditsDatabase_Impl extends CreditsDatabase {
  private volatile CreditsDAO _creditsDAO;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `CreditsEntity` (`adult` INTEGER NOT NULL, `cast_id` INTEGER NOT NULL, `character` TEXT NOT NULL, `credit_id` TEXT NOT NULL, `gender` INTEGER NOT NULL, `known_for_department` TEXT NOT NULL, `name` TEXT NOT NULL, `order` INTEGER NOT NULL, `original_name` TEXT NOT NULL, `popularity` REAL NOT NULL, `profile_path` TEXT NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5058c4c762036107420bc9529b4afb8f')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `CreditsEntity`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCreditsEntity = new HashMap<String, TableInfo.Column>(12);
        _columnsCreditsEntity.put("adult", new TableInfo.Column("adult", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("cast_id", new TableInfo.Column("cast_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("character", new TableInfo.Column("character", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("credit_id", new TableInfo.Column("credit_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("gender", new TableInfo.Column("gender", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("known_for_department", new TableInfo.Column("known_for_department", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("order", new TableInfo.Column("order", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("original_name", new TableInfo.Column("original_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("popularity", new TableInfo.Column("popularity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("profile_path", new TableInfo.Column("profile_path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditsEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreditsEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreditsEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreditsEntity = new TableInfo("CreditsEntity", _columnsCreditsEntity, _foreignKeysCreditsEntity, _indicesCreditsEntity);
        final TableInfo _existingCreditsEntity = TableInfo.read(db, "CreditsEntity");
        if (!_infoCreditsEntity.equals(_existingCreditsEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "CreditsEntity(com.example.tweetytube.features.details.data.local.CreditsEntity).\n"
                  + " Expected:\n" + _infoCreditsEntity + "\n"
                  + " Found:\n" + _existingCreditsEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5058c4c762036107420bc9529b4afb8f", "b9a128093b08c5fb35ceee04659da971");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "CreditsEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `CreditsEntity`");
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
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CreditsDAO.class, CreditsDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CreditsDAO getCreditsDao() {
    if (_creditsDAO != null) {
      return _creditsDAO;
    } else {
      synchronized(this) {
        if(_creditsDAO == null) {
          _creditsDAO = new CreditsDAO_Impl(this);
        }
        return _creditsDAO;
      }
    }
  }
}
