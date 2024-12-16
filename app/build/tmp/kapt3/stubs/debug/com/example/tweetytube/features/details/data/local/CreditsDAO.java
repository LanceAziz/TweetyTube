package com.example.tweetytube.features.details.data.local;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Upsert;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/tweetytube/features/details/data/local/CreditsDAO;", "", "getCastByMovieId", "", "Lcom/example/tweetytube/features/details/data/local/CreditsEntity;", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertMovieList", "", "casts", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface CreditsDAO {
    
    @androidx.room.Upsert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsertMovieList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.features.details.data.local.CreditsEntity> casts, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM CreditsEntity WHERE id = :movieId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCastByMovieId(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.tweetytube.features.details.data.local.CreditsEntity>> $completion);
}