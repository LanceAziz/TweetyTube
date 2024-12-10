package com.example.tweetytube.movie_list.data.repo.local;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Upsert;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/tweetytube/movie_list/data/repo/local/MovieDAO;", "", "getMovieById", "Lcom/example/tweetytube/movie_list/data/repo/local/MovieEntity;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesByCategory", "", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertMovieList", "", "movies", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface MovieDAO {
    
    @androidx.room.Upsert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsertMovieList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.movie_list.data.repo.local.MovieEntity> movies, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM MovieEntity WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMovieById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.tweetytube.movie_list.data.repo.local.MovieEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM MovieEntity WHERE category = :category")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMoviesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.tweetytube.movie_list.data.repo.local.MovieEntity>> $completion);
}