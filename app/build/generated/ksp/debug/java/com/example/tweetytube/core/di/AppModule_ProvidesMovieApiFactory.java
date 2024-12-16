package com.example.tweetytube.core.di;

import com.example.tweetytube.features.movieList.data.remote.MoviesApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvidesMovieApiFactory implements Factory<MoviesApi> {
  @Override
  public MoviesApi get() {
    return providesMovieApi();
  }

  public static AppModule_ProvidesMovieApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MoviesApi providesMovieApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesMovieApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvidesMovieApiFactory INSTANCE = new AppModule_ProvidesMovieApiFactory();
  }
}
