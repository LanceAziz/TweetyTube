package com.example.tweetytube.movie_list.data.repo.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.tweetytube.features.details.data.local.CreditsDAO;
import com.example.tweetytube.features.details.data.local.CreditsEntity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/tweetytube/movie_list/data/repo/local/MovieDatabase;", "Landroidx/room/RoomDatabase;", "()V", "movieDao", "Lcom/example/tweetytube/movie_list/data/repo/local/MovieDAO;", "getMovieDao", "()Lcom/example/tweetytube/movie_list/data/repo/local/MovieDAO;", "app_release"})
@androidx.room.Database(entities = {com.example.tweetytube.movie_list.data.repo.local.MovieEntity.class}, version = 1)
public abstract class MovieDatabase extends androidx.room.RoomDatabase {
    
    public MovieDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.tweetytube.movie_list.data.repo.local.MovieDAO getMovieDao();
}