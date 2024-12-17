package com.example.tweetytube.core.di;

import android.app.Application;
import com.example.tweetytube.movie_list.data.repo.local.MovieDatabase;
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
public final class AppModule_ProvideMovieDatabaseFactory implements Factory<MovieDatabase> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideMovieDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public MovieDatabase get() {
    return provideMovieDatabase(appProvider.get());
  }

  public static AppModule_ProvideMovieDatabaseFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvideMovieDatabaseFactory(appProvider);
  }

  public static MovieDatabase provideMovieDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMovieDatabase(app));
  }
}
