package com.example.tweetytube.features.details.presentation.viewModel;

import com.example.tweetytube.features.details.domain.model.Credits;
import com.example.tweetytube.movie_list.data.repo.local.Movie;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/example/tweetytube/features/details/presentation/viewModel/DetailsState;", "", "isMovieLoading", "", "isCreditsLoading", "currentMovieId", "", "movie", "Lcom/example/tweetytube/movie_list/data/repo/local/Movie;", "credits", "", "Lcom/example/tweetytube/features/details/domain/model/Credits;", "(ZZILcom/example/tweetytube/movie_list/data/repo/local/Movie;Ljava/util/List;)V", "getCredits", "()Ljava/util/List;", "getCurrentMovieId", "()I", "()Z", "getMovie", "()Lcom/example/tweetytube/movie_list/data/repo/local/Movie;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class DetailsState {
    private final boolean isMovieLoading = false;
    private final boolean isCreditsLoading = false;
    private final int currentMovieId = 0;
    @org.jetbrains.annotations.Nullable()
    private final com.example.tweetytube.movie_list.data.repo.local.Movie movie = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.tweetytube.features.details.domain.model.Credits> credits = null;
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.tweetytube.movie_list.data.repo.local.Movie component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.features.details.domain.model.Credits> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tweetytube.features.details.presentation.viewModel.DetailsState copy(boolean isMovieLoading, boolean isCreditsLoading, int currentMovieId, @org.jetbrains.annotations.Nullable()
    com.example.tweetytube.movie_list.data.repo.local.Movie movie, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.features.details.domain.model.Credits> credits) {
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
    
    public DetailsState(boolean isMovieLoading, boolean isCreditsLoading, int currentMovieId, @org.jetbrains.annotations.Nullable()
    com.example.tweetytube.movie_list.data.repo.local.Movie movie, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tweetytube.features.details.domain.model.Credits> credits) {
        super();
    }
    
    public final boolean isMovieLoading() {
        return false;
    }
    
    public final boolean isCreditsLoading() {
        return false;
    }
    
    public final int getCurrentMovieId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.tweetytube.movie_list.data.repo.local.Movie getMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.tweetytube.features.details.domain.model.Credits> getCredits() {
        return null;
    }
    
    public DetailsState() {
        super();
    }
}