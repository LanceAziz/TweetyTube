package com.example.tweetytube.features.movieList.data.remote;

import com.example.tweetytube.movie_list.data.repo.remote.response.MovieListDto;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/tweetytube/features/movieList/data/remote/MoviesApi;", "", "getMovies", "Lcom/example/tweetytube/movie_list/data/repo/remote/response/MovieListDto;", "category", "", "page", "", "apiKey", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface MoviesApi {
    
    @retrofit2.http.GET(value = "movie/{category}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMovies(@retrofit2.http.Path(value = "category")
    @org.jetbrains.annotations.NotNull()
    java.lang.String category, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.tweetytube.movie_list.data.repo.remote.response.MovieListDto> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}