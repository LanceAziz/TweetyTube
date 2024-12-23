package com.example.tweetytube.features.details.presentation.viewModel;

import androidx.lifecycle.ViewModel;
import com.example.tweetytube.core.utils.Resource;
import com.example.tweetytube.features.details.domain.repo.CreditsRepo;
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/tweetytube/features/details/presentation/viewModel/DetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "movieListRepository", "Lcom/example/tweetytube/features/movieList/domain/repo/MovieListRepo;", "creditsRepository", "Lcom/example/tweetytube/features/details/domain/repo/CreditsRepo;", "(Lcom/example/tweetytube/features/movieList/domain/repo/MovieListRepo;Lcom/example/tweetytube/features/details/domain/repo/CreditsRepo;)V", "_detailsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/tweetytube/features/details/presentation/viewModel/DetailsState;", "detailsState", "Lkotlinx/coroutines/flow/StateFlow;", "getDetailsState", "()Lkotlinx/coroutines/flow/StateFlow;", "movieId", "", "getCredits", "", "id", "getMovie", "setCurrentMovieId", "value", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.features.movieList.domain.repo.MovieListRepo movieListRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.features.details.domain.repo.CreditsRepo creditsRepository = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.example.tweetytube.features.details.presentation.viewModel.DetailsState> _detailsState;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.tweetytube.features.details.presentation.viewModel.DetailsState> detailsState = null;
    private final int movieId = 0;
    
    @javax.inject.Inject()
    public DetailsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.movieList.domain.repo.MovieListRepo movieListRepository, @org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.details.domain.repo.CreditsRepo creditsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.tweetytube.features.details.presentation.viewModel.DetailsState> getDetailsState() {
        return null;
    }
    
    public final void setCurrentMovieId(int value) {
    }
    
    private final void getMovie(int id) {
    }
    
    private final void getCredits(int id) {
    }
}