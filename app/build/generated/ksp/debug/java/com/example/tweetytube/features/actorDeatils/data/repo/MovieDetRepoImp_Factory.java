package com.example.tweetytube.features.actorDeatils.data.repo;

import com.example.tweetytube.features.actorDeatils.data.local.MovieDetDatabase;
import com.example.tweetytube.features.actorDeatils.data.remote.MovieDetApi;
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
public final class MovieDetRepoImp_Factory implements Factory<MovieDetRepoImp> {
  private final Provider<MovieDetApi> movieDetApiProvider;

  private final Provider<MovieDetDatabase> movieDetDatabaseProvider;

  public MovieDetRepoImp_Factory(Provider<MovieDetApi> movieDetApiProvider,
      Provider<MovieDetDatabase> movieDetDatabaseProvider) {
    this.movieDetApiProvider = movieDetApiProvider;
    this.movieDetDatabaseProvider = movieDetDatabaseProvider;
  }

  @Override
  public MovieDetRepoImp get() {
    return newInstance(movieDetApiProvider.get(), movieDetDatabaseProvider.get());
  }

  public static MovieDetRepoImp_Factory create(Provider<MovieDetApi> movieDetApiProvider,
      Provider<MovieDetDatabase> movieDetDatabaseProvider) {
    return new MovieDetRepoImp_Factory(movieDetApiProvider, movieDetDatabaseProvider);
  }

  public static MovieDetRepoImp newInstance(MovieDetApi movieDetApi,
      MovieDetDatabase movieDetDatabase) {
    return new MovieDetRepoImp(movieDetApi, movieDetDatabase);
  }
}
