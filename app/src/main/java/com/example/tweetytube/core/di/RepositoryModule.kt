package com.example.tweetytube.core.di

import com.example.tweetytube.features.movieList.data.repo.MovieListRepoImp
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieListRepository(
        movieListRepositoryImpl: MovieListRepoImp
    ): MovieListRepo

}