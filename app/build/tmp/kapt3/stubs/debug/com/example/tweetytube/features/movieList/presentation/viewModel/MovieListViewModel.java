package com.example.tweetytube.features.movieList.presentation.viewModel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.tweetytube.core.utils.Category;
import com.example.tweetytube.core.utils.Resource;
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/example/tweetytube/features/movieList/presentation/viewModel/MovieListViewModel;", "Landroidx/lifecycle/ViewModel;", "movieListRepository", "Lcom/example/tweetytube/features/movieList/domain/repo/MovieListRepo;", "(Lcom/example/tweetytube/features/movieList/domain/repo/MovieListRepo;)V", "_movieListState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/tweetytube/features/movieList/presentation/viewModel/MovieListState;", "_searchText", "Landroidx/compose/runtime/MutableState;", "", "movieListState", "Lkotlinx/coroutines/flow/StateFlow;", "getMovieListState", "()Lkotlinx/coroutines/flow/StateFlow;", "searchText", "getSearchText", "()Landroidx/compose/runtime/MutableState;", "fetchAllMovies", "", "fetchMovies", "forceFetchFromRemote", "", "category", "onEvent", "event", "Lcom/example/tweetytube/features/movieList/presentation/viewModel/MovieListUiEvent;", "setSearchText", "value", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MovieListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.features.movieList.domain.repo.MovieListRepo movieListRepository = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.example.tweetytube.features.movieList.presentation.viewModel.MovieListState> _movieListState;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.tweetytube.features.movieList.presentation.viewModel.MovieListState> movieListState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.String> _searchText = null;
    
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
    public final androidx.compose.runtime.MutableState<java.lang.String> getSearchText() {
        return null;
    }
    
    public final void setSearchText(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.movieList.presentation.viewModel.MovieListUiEvent event) {
    }
    
    private final void fetchAllMovies() {
    }
    
    private final void fetchMovies(boolean forceFetchFromRemote, java.lang.String category) {
    }
}