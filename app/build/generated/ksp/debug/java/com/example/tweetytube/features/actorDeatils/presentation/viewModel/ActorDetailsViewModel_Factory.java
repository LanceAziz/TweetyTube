package com.example.tweetytube.features.actorDeatils.presentation.viewModel;

import com.example.tweetytube.features.actorDeatils.domain.repo.MovieDetRepo;
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
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class ActorDetailsViewModel_Factory implements Factory<ActorDetailsViewModel> {
  private final Provider<MovieDetRepo> movieDetailsRepositoryProvider;

  public ActorDetailsViewModel_Factory(Provider<MovieDetRepo> movieDetailsRepositoryProvider) {
    this.movieDetailsRepositoryProvider = movieDetailsRepositoryProvider;
  }

  @Override
  public ActorDetailsViewModel get() {
    return newInstance(movieDetailsRepositoryProvider.get());
  }

  public static ActorDetailsViewModel_Factory create(
      Provider<MovieDetRepo> movieDetailsRepositoryProvider) {
    return new ActorDetailsViewModel_Factory(movieDetailsRepositoryProvider);
  }

  public static ActorDetailsViewModel newInstance(MovieDetRepo movieDetailsRepository) {
    return new ActorDetailsViewModel(movieDetailsRepository);
  }
}
