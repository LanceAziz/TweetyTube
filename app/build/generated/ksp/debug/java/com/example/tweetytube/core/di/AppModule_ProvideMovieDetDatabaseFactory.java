package com.example.tweetytube.core.di;

import android.app.Application;
import com.example.tweetytube.features.actorDeatils.data.local.MovieDetDatabase;
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
public final class AppModule_ProvideMovieDetDatabaseFactory implements Factory<MovieDetDatabase> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideMovieDetDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public MovieDetDatabase get() {
    return provideMovieDetDatabase(appProvider.get());
  }

  public static AppModule_ProvideMovieDetDatabaseFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvideMovieDetDatabaseFactory(appProvider);
  }

  public static MovieDetDatabase provideMovieDetDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMovieDetDatabase(app));
  }
}
