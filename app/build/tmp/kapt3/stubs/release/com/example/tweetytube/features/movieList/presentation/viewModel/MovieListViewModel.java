package com.example.tweetytube.features.movieList.presentation.viewModel;

import androidx.lifecycle.ViewModel;
import com.example.tweetytube.core.utils.Category;
import com.example.tweetytube.core.utils.Resource;
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u0016\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bJ\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-J\u0016\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u000bJ\u000e\u00102\u001a\u00020$2\u0006\u00101\u001a\u00020\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0012R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0012\u00a8\u00063"}, d2 = {"Lcom/example/tweetytube/features/movieList/presentation/viewModel/MovieListViewModel;", "Landroidx/lifecycle/ViewModel;", "movieListRepository", "Lcom/example/tweetytube/features/movieList/domain/repo/MovieListRepo;", "(Lcom/example/tweetytube/features/movieList/domain/repo/MovieListRepo;)V", "_movieListState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/tweetytube/features/movieList/presentation/viewModel/MovieListState;", "_searchState", "Lcom/example/tweetytube/features/movieList/presentation/viewModel/SearchState;", "filter", "", "getFilter", "()Ljava/lang/String;", "getSearchResult", "", "Lcom/example/tweetytube/movie_list/data/repo/local/Movie;", "getGetSearchResult", "()Ljava/util/List;", "movieListState", "Lkotlinx/coroutines/flow/StateFlow;", "getMovieListState", "()Lkotlinx/coroutines/flow/StateFlow;", "popularMovieList", "getPopularMovieList", "searchJob", "Lkotlinx/coroutines/Job;", "searchState", "getSearchState", "searchText", "getSearchText", "topRatedMovieList", "getTopRatedMovieList", "upcomingMovieList", "getUpcomingMovieList", "fetchAllMovies", "", "fetchMovies", "forceFetchFromRemote", "", "category", "movieQuery", "text", "onEvent", "event", "Lcom/example/tweetytube/features/movieList/presentation/viewModel/MovieListUiEvent;", "reboundedSearch", "newText", "setFilter", "value", "setSearchText", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MovieListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.features.movieList.domain.repo.MovieListRepo movieListRepository = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.example.tweetytube.features.movieList.presentation.viewModel.MovieListState> _movieListState;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.tweetytube.features.movieList.presentation.viewModel.MovieListState> movieListState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.tweetytube.features.movieList.presentation.viewModel.SearchState> _searchState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.tweetytube.features.movieList.presentation.viewModel.SearchState> searchState = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job searchJob;
    
    @javax.inject.Inject()
    public MovieListViewModel(@org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.movieList.domain.repo.MovieListRepo movieListRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.tweetytube.features.movieList.presentation.viewModel.MovieListState> getMovieListState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.tweetytube.features.movieList.presentation.viewModel.SearchState> getSearchState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSearchText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.movie_list.data.repo.local.Movie> getGetSearchResult() {
        return null;
    }
    
    public final void setSearchText(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
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
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.movieList.presentation.viewModel.MovieListUiEvent event) {
    }
    
    private final void fetchAllMovies() {
    }
    
    public final void reboundedSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String newText, @org.jetbrains.annotations.NotNull()
    java.lang.String filter) {
    }
    
    public final void movieQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    private final void fetchMovies(boolean forceFetchFromRemote, java.lang.String category) {
    }
}