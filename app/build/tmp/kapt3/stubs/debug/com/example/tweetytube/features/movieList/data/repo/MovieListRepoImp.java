package com.example.tweetytube.features.movieList.data.repo;

import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo;
import com.example.tweetytube.movie_list.data.repo.local.Movie;
import com.example.tweetytube.movie_list.data.repo.local.MovieDatabase;
import com.example.tweetytube.movie_list.data.repo.remote.MoviesApi;
import com.example.tweetytube.core.utils.Resource;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ8\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/tweetytube/features/movieList/data/repo/MovieListRepoImp;", "Lcom/example/tweetytube/features/movieList/domain/repo/MovieListRepo;", "movieApi", "Lcom/example/tweetytube/movie_list/data/repo/remote/MoviesApi;", "movieDatabase", "Lcom/example/tweetytube/movie_list/data/repo/local/MovieDatabase;", "(Lcom/example/tweetytube/movie_list/data/repo/remote/MoviesApi;Lcom/example/tweetytube/movie_list/data/repo/local/MovieDatabase;)V", "getMovie", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/tweetytube/core/utils/Resource;", "Lcom/example/tweetytube/movie_list/data/repo/local/Movie;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieList", "", "forceFetchFromRemote", "", "category", "", "page", "(ZLjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MovieListRepoImp implements com.example.tweetytube.features.movieList.domain.repo.MovieListRepo {
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.movie_list.data.repo.remote.MoviesApi movieApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.movie_list.data.repo.local.MovieDatabase movieDatabase = null;
    
    @javax.inject.Inject()
    public MovieListRepoImp(@org.jetbrains.annotations.NotNull()
    com.example.tweetytube.movie_list.data.repo.remote.MoviesApi movieApi, @org.jetbrains.annotations.NotNull()
    com.example.tweetytube.movie_list.data.repo.local.MovieDatabase movieDatabase) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getMovieList(boolean forceFetchFromRemote, @org.jetbrains.annotations.NotNull()
    java.lang.String category, int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.tweetytube.core.utils.Resource<java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie>>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getMovie(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.tweetytube.core.utils.Resource<com.example.tweetytube.movie_list.data.repo.local.Movie>>> $completion) {
        return null;
    }
}