package com.example.tweetytube.features.details.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CreditsDAO_Impl implements CreditsDAO {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<CreditsEntity> __upsertionAdapterOfCreditsEntity;

  public CreditsDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfCreditsEntity = new EntityUpsertionAdapter<CreditsEntity>(new EntityInsertionAdapter<CreditsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `CreditsEntity` (`adult`,`cast_id`,`character`,`credit_id`,`gender`,`known_for_department`,`name`,`order`,`original_name`,`popularity`,`profile_path`,`id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CreditsEntity entity) {
        final int _tmp = entity.getAdult() ? 1 : 0;
        statement.bindLong(1, _tmp);
        statement.bindLong(2, entity.getCast_id());
        statement.bindString(3, entity.getCharacter());
        statement.bindString(4, entity.getCredit_id());
        statement.bindLong(5, entity.getGender());
        statement.bindString(6, entity.getKnown_for_department());
        statement.bindString(7, entity.getName());
        statement.bindLong(8, entity.getOrder());
        statement.bindString(9, entity.getOriginal_name());
        statement.bindDouble(10, entity.getPopularity());
        statement.bindString(11, entity.getProfile_path());
        statement.bindLong(12, entity.getId());
      }
    }, new EntityDeletionOrUpdateAdapter<CreditsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `CreditsEntity` SET `adult` = ?,`cast_id` = ?,`character` = ?,`credit_id` = ?,`gender` = ?,`known_for_department` = ?,`name` = ?,`order` = ?,`original_name` = ?,`popularity` = ?,`profile_path` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CreditsEntity entity) {
        final int _tmp = entity.getAdult() ? 1 : 0;
        statement.bindLong(1, _tmp);
        statement.bindLong(2, entity.getCast_id());
        statement.bindString(3, entity.getCharacter());
        statement.bindString(4, entity.getCredit_id());
        statement.bindLong(5, entity.getGender());
        statement.bindString(6, entity.getKnown_for_department());
        statement.bindString(7, entity.getName());
        statement.bindLong(8, entity.getOrder());
        statement.bindString(9, entity.getOriginal_name());
        statement.bindDouble(10, entity.getPopularity());
        statement.bindString(11, entity.getProfile_path());
        statement.bindLong(12, entity.getId());
        statement.bindLong(13, entity.getId());
      }
    });
  }

  @Override
  public Object upsertMovieList(final List<CreditsEntity> casts,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfCreditsEntity.upsert(casts);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getCastByMovieId(final int movieId,
      final Continuation<? super List<CreditsEntity>> $completion) {
    final String _sql = "SELECT * FROM CreditsEntity WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, movieId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<CreditsEntity>>() {
      @Override
      @NonNull
      public List<CreditsEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAdult = CursorUtil.getColumnIndexOrThrow(_cursor, "adult");
          final int _cursorIndexOfCastId = CursorUtil.getColumnIndexOrThrow(_cursor, "cast_id");
          final int _cursorIndexOfCharacter = CursorUtil.getColumnIndexOrThrow(_cursor, "character");
          final int _cursorIndexOfCreditId = CursorUtil.getColumnIndexOrThrow(_cursor, "credit_id");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfKnownForDepartment = CursorUtil.getColumnIndexOrThrow(_cursor, "known_for_department");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "order");
          final int _cursorIndexOfOriginalName = CursorUtil.getColumnIndexOrThrow(_cursor, "original_name");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfProfilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_path");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<CreditsEntity> _result = new ArrayList<CreditsEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CreditsEntity _item;
            final boolean _tmpAdult;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAdult);
            _tmpAdult = _tmp != 0;
            final int _tmpCast_id;
            _tmpCast_id = _cursor.getInt(_cursorIndexOfCastId);
            final String _tmpCharacter;
            _tmpCharacter = _cursor.getString(_cursorIndexOfCharacter);
            final String _tmpCredit_id;
            _tmpCredit_id = _cursor.getString(_cursorIndexOfCreditId);
            final int _tmpGender;
            _tmpGender = _cursor.getInt(_cursorIndexOfGender);
            final String _tmpKnown_for_department;
            _tmpKnown_for_department = _cursor.getString(_cursorIndexOfKnownForDepartment);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final int _tmpOrder;
            _tmpOrder = _cursor.getInt(_cursorIndexOfOrder);
            final String _tmpOriginal_name;
            _tmpOriginal_name = _cursor.getString(_cursorIndexOfOriginalName);
            final double _tmpPopularity;
            _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            final String _tmpProfile_path;
            _tmpProfile_path = _cursor.getString(_cursorIndexOfProfilePath);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new CreditsEntity(_tmpAdult,_tmpCast_id,_tmpCharacter,_tmpCredit_id,_tmpGender,_tmpKnown_for_department,_tmpName,_tmpOrder,_tmpOriginal_name,_tmpPopularity,_tmpProfile_path,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
