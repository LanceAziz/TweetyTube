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
    "cast"
})
public final class AppModule_ProvidesMovieDatabaseFactory implements Factory<MovieDatabase> {
  private final Provider<Application> appProvider;

  public AppModule_ProvidesMovieDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public MovieDatabase get() {
    return providesMovieDatabase(appProvider.get());
  }

  public static AppModule_ProvidesMovieDatabaseFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvidesMovieDatabaseFactory(appProvider);
  }

  public static MovieDatabase providesMovieDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesMovieDatabase(app));
  }
}
