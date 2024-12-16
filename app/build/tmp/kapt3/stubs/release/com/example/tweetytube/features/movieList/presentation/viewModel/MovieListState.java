package com.example.tweetytube.features.movieList.presentation.viewModel;

import com.example.tweetytube.core.utils.Category;
import com.example.tweetytube.movie_list.data.repo.local.Movie;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\u007f\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020\tH\u00d6\u0001J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018\u00a8\u0006,"}, d2 = {"Lcom/example/tweetytube/features/movieList/presentation/viewModel/MovieListState;", "", "isLoadingPopular", "", "isLoadingUpcoming", "isLoadingTopRated", "currentCategory", "", "popularMovieListPage", "", "upcomingMovieListPage", "topRatedMovieListPage", "popularMovieList", "", "Lcom/example/tweetytube/movie_list/data/repo/local/Movie;", "upcomingMovieList", "topRatedMovieList", "(ZZZLjava/lang/String;IIILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCurrentCategory", "()Ljava/lang/String;", "()Z", "getPopularMovieList", "()Ljava/util/List;", "getPopularMovieListPage", "()I", "getTopRatedMovieList", "getTopRatedMovieListPage", "getUpcomingMovieList", "getUpcomingMovieListPage", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"})
public final class MovieListState {
    private final boolean isLoadingPopular = false;
    private final boolean isLoadingUpcoming = false;
    private final boolean isLoadingTopRated = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currentCategory = null;
    private final int popularMovieListPage = 0;
    private final int upcomingMovieListPage = 0;
    private final int topRatedMovieListPage = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> popularMovieList = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> upcomingMovieList = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> topRatedMovieList = null;
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> component10() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tweetytube.features.movieList.presentation.viewModel.MovieListState copy(boolean isLoadingPopular, boolean isLoadingUpcoming, boolean isLoadingTopRated, @org.jetbrains.annotations.NotNull()
    java.lang.String currentCategory, int popularMovieListPage, int upcomingMovieListPage, int topRatedMovieListPage, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> popularMovieList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> upcomingMovieList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> topRatedMovieList) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public MovieListState(boolean isLoadingPopular, boolean isLoadingUpcoming, boolean isLoadingTopRated, @org.jetbrains.annotations.NotNull()
    java.lang.String currentCategory, int popularMovieListPage, int upcomingMovieListPage, int topRatedMovieListPage, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> popularMovieList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> upcomingMovieList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> topRatedMovieList) {
        super();
    }
    
    public final boolean isLoadingPopular() {
        return false;
    }
    
    public final boolean isLoadingUpcoming() {
        return false;
    }
    
    public final boolean isLoadingTopRated() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentCategory() {
        return null;
    }
    
    public final int getPopularMovieListPage() {
        return 0;
    }
    
    public final int getUpcomingMovieListPage() {
        return 0;
    }
    
    public final int getTopRatedMovieListPage() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> getPopularMovieList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> getUpcomingMovieList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> getTopRatedMovieList() {
        return null;
    }
    
    public MovieListState() {
        super();
    }
}