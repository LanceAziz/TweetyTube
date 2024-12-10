package com.example.tweetytube.movie_list.data.repo.remote;

import com.example.tweetytube.BuildConfig;
import com.example.tweetytube.movie_list.data.repo.remote.response.MovieListDto;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/example/tweetytube/movie_list/data/repo/remote/MoviesApi;", "", "getMovies", "Lcom/example/tweetytube/movie_list/data/repo/remote/response/MovieListDto;", "category", "", "page", "", "apiKey", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface MoviesApi {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://api.themoviedb.org/3/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w342";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MOVIES_API_KEY = "8241c60115d870af1e78bd6956903198";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.tweetytube.movie_list.data.repo.remote.MoviesApi.Companion Companion = null;
    
    @retrofit2.http.GET(value = "movie/{category}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMovies(@retrofit2.http.Path(value = "category")
    @org.jetbrains.annotations.NotNull()
    java.lang.String category, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.tweetytube.movie_list.data.repo.remote.response.MovieListDto> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/tweetytube/movie_list/data/repo/remote/MoviesApi$Companion;", "", "()V", "BASE_URL", "", "IMAGE_BASE_URL", "MOVIES_API_KEY", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://api.themoviedb.org/3/";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w342";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String MOVIES_API_KEY = "8241c60115d870af1e78bd6956903198";
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}