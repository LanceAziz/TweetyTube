package com.example.tweetytube.features.details.presentation.viewModel;

import com.example.tweetytube.features.details.domain.repo.CreditsRepo;
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
public final class DetailsViewModel_Factory implements Factory<DetailsViewModel> {
  private final Provider<MovieListRepo> movieListRepositoryProvider;

  private final Provider<CreditsRepo> creditsRepositoryProvider;

  public DetailsViewModel_Factory(Provider<MovieListRepo> movieListRepositoryProvider,
      Provider<CreditsRepo> creditsRepositoryProvider) {
    this.movieListRepositoryProvider = movieListRepositoryProvider;
    this.creditsRepositoryProvider = creditsRepositoryProvider;
  }

  @Override
  public DetailsViewModel get() {
    return newInstance(movieListRepositoryProvider.get(), creditsRepositoryProvider.get());
  }

  public static DetailsViewModel_Factory create(Provider<MovieListRepo> movieListRepositoryProvider,
      Provider<CreditsRepo> creditsRepositoryProvider) {
    return new DetailsViewModel_Factory(movieListRepositoryProvider, creditsRepositoryProvider);
  }

  public static DetailsViewModel newInstance(MovieListRepo movieListRepository,
      CreditsRepo creditsRepository) {
    return new DetailsViewModel(movieListRepository, creditsRepository);
  }
}
