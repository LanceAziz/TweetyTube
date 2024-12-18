package com.example.tweetytube.core.di;

import com.example.tweetytube.features.actorDeatils.data.local.MovieDetDatabase;
import com.example.tweetytube.features.actorDeatils.data.remote.MovieDetApi;
import com.example.tweetytube.features.actorDeatils.domain.repo.MovieDetRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideMovieDetRepoFactory implements Factory<MovieDetRepo> {
  private final Provider<MovieDetApi> movieDetApiProvider;

  private final Provider<MovieDetDatabase> movieDetDatabaseProvider;

  public AppModule_ProvideMovieDetRepoFactory(Provider<MovieDetApi> movieDetApiProvider,
      Provider<MovieDetDatabase> movieDetDatabaseProvider) {
    this.movieDetApiProvider = movieDetApiProvider;
    this.movieDetDatabaseProvider = movieDetDatabaseProvider;
  }

  @Override
  public MovieDetRepo get() {
    return provideMovieDetRepo(movieDetApiProvider.get(), movieDetDatabaseProvider.get());
  }

  public static AppModule_ProvideMovieDetRepoFactory create(
      Provider<MovieDetApi> movieDetApiProvider,
      Provider<MovieDetDatabase> movieDetDatabaseProvider) {
    return new AppModule_ProvideMovieDetRepoFactory(movieDetApiProvider, movieDetDatabaseProvider);
  }

  public static MovieDetRepo provideMovieDetRepo(MovieDetApi movieDetApi,
      MovieDetDatabase movieDetDatabase) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMovieDetRepo(movieDetApi, movieDetDatabase));
  }
}
