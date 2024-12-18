package com.example.tweetytube.features.actorDeatils.data.local;

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
public final class MovieDetDAO_Impl implements MovieDetDAO {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<MovieDetEntity> __upsertionAdapterOfMovieDetEntity;

  public MovieDetDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfMovieDetEntity = new EntityUpsertionAdapter<MovieDetEntity>(new EntityInsertionAdapter<MovieDetEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `MovieDetEntity` (`adult`,`backdrop_path`,`genre_ids`,`original_language`,`original_title`,`overview`,`popularity`,`poster_path`,`release_date`,`title`,`video`,`vote_average`,`vote_count`,`id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MovieDetEntity entity) {
        final int _tmp = entity.getAdult() ? 1 : 0;
        statement.bindLong(1, _tmp);
        statement.bindString(2, entity.getBackdrop_path());
        statement.bindString(3, entity.getGenre_ids());
        statement.bindString(4, entity.getOriginal_language());
        statement.bindString(5, entity.getOriginal_title());
        statement.bindString(6, entity.getOverview());
        statement.bindDouble(7, entity.getPopularity());
        statement.bindString(8, entity.getPoster_path());
        statement.bindString(9, entity.getRelease_date());
        statement.bindString(10, entity.getTitle());
        final int _tmp_1 = entity.getVideo() ? 1 : 0;
        statement.bindLong(11, _tmp_1);
        statement.bindDouble(12, entity.getVote_average());
        statement.bindLong(13, entity.getVote_count());
        statement.bindLong(14, entity.getId());
      }
    }, new EntityDeletionOrUpdateAdapter<MovieDetEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `MovieDetEntity` SET `adult` = ?,`backdrop_path` = ?,`genre_ids` = ?,`original_language` = ?,`original_title` = ?,`overview` = ?,`popularity` = ?,`poster_path` = ?,`release_date` = ?,`title` = ?,`video` = ?,`vote_average` = ?,`vote_count` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MovieDetEntity entity) {
        final int _tmp = entity.getAdult() ? 1 : 0;
        statement.bindLong(1, _tmp);
        statement.bindString(2, entity.getBackdrop_path());
        statement.bindString(3, entity.getGenre_ids());
        statement.bindString(4, entity.getOriginal_language());
        statement.bindString(5, entity.getOriginal_title());
        statement.bindString(6, entity.getOverview());
        statement.bindDouble(7, entity.getPopularity());
        statement.bindString(8, entity.getPoster_path());
        statement.bindString(9, entity.getRelease_date());
        statement.bindString(10, entity.getTitle());
        final int _tmp_1 = entity.getVideo() ? 1 : 0;
        statement.bindLong(11, _tmp_1);
        statement.bindDouble(12, entity.getVote_average());
        statement.bindLong(13, entity.getVote_count());
        statement.bindLong(14, entity.getId());
        statement.bindLong(15, entity.getId());
      }
    });
  }

  @Override
  public Object upsertCreditList(final List<MovieDetEntity> movieDet,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfMovieDetEntity.upsert(movieDet);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMovieByCreditId(final int castId,
      final Continuation<? super List<MovieDetEntity>> $completion) {
    final String _sql = "SELECT * FROM MovieDetEntity WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, castId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<MovieDetEntity>>() {
      @Override
      @NonNull
      public List<MovieDetEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAdult = CursorUtil.getColumnIndexOrThrow(_cursor, "adult");
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
          final int _cursorIndexOfGenreIds = CursorUtil.getColumnIndexOrThrow(_cursor, "genre_ids");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "original_language");
          final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "original_title");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
          final int _cursorIndexOfVoteCount = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_count");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<MovieDetEntity> _result = new ArrayList<MovieDetEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MovieDetEntity _item;
            final boolean _tmpAdult;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAdult);
            _tmpAdult = _tmp != 0;
            final String _tmpBackdrop_path;
            _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
            final String _tmpGenre_ids;
            _tmpGenre_ids = _cursor.getString(_cursorIndexOfGenreIds);
            final String _tmpOriginal_language;
            _tmpOriginal_language = _cursor.getString(_cursorIndexOfOriginalLanguage);
            final String _tmpOriginal_title;
            _tmpOriginal_title = _cursor.getString(_cursorIndexOfOriginalTitle);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            final double _tmpPopularity;
            _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            final String _tmpPoster_path;
            _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            final String _tmpRelease_date;
            _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final boolean _tmpVideo;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfVideo);
            _tmpVideo = _tmp_1 != 0;
            final double _tmpVote_average;
            _tmpVote_average = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final int _tmpVote_count;
            _tmpVote_count = _cursor.getInt(_cursorIndexOfVoteCount);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new MovieDetEntity(_tmpAdult,_tmpBackdrop_path,_tmpGenre_ids,_tmpOriginal_language,_tmpOriginal_title,_tmpOverview,_tmpPopularity,_tmpPoster_path,_tmpRelease_date,_tmpTitle,_tmpVideo,_tmpVote_average,_tmpVote_count,_tmpId);
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
