package com.example.tweetytube.features.movieList.presentation.viewModel;

import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo;
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
public final class MovieListViewModel_Factory implements Factory<MovieListViewModel> {
  private final Provider<MovieListRepo> movieListRepositoryProvider;

  public MovieListViewModel_Factory(Provider<MovieListRepo> movieListRepositoryProvider) {
    this.movieListRepositoryProvider = movieListRepositoryProvider;
  }

  @Override
  public MovieListViewModel get() {
    return newInstance(movieListRepositoryProvider.get());
  }

  public static MovieListViewModel_Factory create(
      Provider<MovieListRepo> movieListRepositoryProvider) {
    return new MovieListViewModel_Factory(movieListRepositoryProvider);
  }

  public static MovieListViewModel newInstance(MovieListRepo movieListRepository) {
    return new MovieListViewModel(movieListRepository);
  }
}
