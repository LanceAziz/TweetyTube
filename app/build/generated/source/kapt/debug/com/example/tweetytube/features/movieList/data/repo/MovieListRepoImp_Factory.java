package com.example.tweetytube.features.movieList.data.repo;

import com.example.tweetytube.features.movieList.data.remote.MoviesApi;
import com.example.tweetytube.movie_list.data.repo.local.MovieDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class MovieListRepoImp_Factory implements Factory<MovieListRepoImp> {
  private final Provider<MoviesApi> movieApiProvider;

  private final Provider<MovieDatabase> movieDatabaseProvider;

  public MovieListRepoImp_Factory(Provider<MoviesApi> movieApiProvider,
      Provider<MovieDatabase> movieDatabaseProvider) {
    this.movieApiProvider = movieApiProvider;
    this.movieDatabaseProvider = movieDatabaseProvider;
  }

  @Override
  public MovieListRepoImp get() {
    return newInstance(movieApiProvider.get(), movieDatabaseProvider.get());
  }

  public static MovieListRepoImp_Factory create(Provider<MoviesApi> movieApiProvider,
      Provider<MovieDatabase> movieDatabaseProvider) {
    return new MovieListRepoImp_Factory(movieApiProvider, movieDatabaseProvider);
  }

  public static MovieListRepoImp newInstance(MoviesApi movieApi, MovieDatabase movieDatabase) {
    return new MovieListRepoImp(movieApi, movieDatabase);
  }
}
