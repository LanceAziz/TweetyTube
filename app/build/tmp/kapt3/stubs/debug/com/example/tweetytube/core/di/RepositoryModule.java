package com.example.tweetytube.core.di;

import com.example.tweetytube.features.details.data.repo.CreditsRepoImp;
import com.example.tweetytube.features.details.domain.model.Credits;
import com.example.tweetytube.features.details.domain.repo.CreditsRepo;
import com.example.tweetytube.features.movieList.data.repo.MovieListRepoImp;
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/tweetytube/core/di/RepositoryModule;", "", "()V", "bindCreditsRepository", "Lcom/example/tweetytube/features/details/domain/repo/CreditsRepo;", "creditsRepositoryImpl", "Lcom/example/tweetytube/features/details/data/repo/CreditsRepoImp;", "bindMovieListRepository", "Lcom/example/tweetytube/features/movieList/domain/repo/MovieListRepo;", "movieListRepositoryImpl", "Lcom/example/tweetytube/features/movieList/data/repo/MovieListRepoImp;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.tweetytube.features.movieList.domain.repo.MovieListRepo bindMovieListRepository(@org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.movieList.data.repo.MovieListRepoImp movieListRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.tweetytube.features.details.domain.repo.CreditsRepo bindCreditsRepository(@org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.details.data.repo.CreditsRepoImp creditsRepositoryImpl);
}