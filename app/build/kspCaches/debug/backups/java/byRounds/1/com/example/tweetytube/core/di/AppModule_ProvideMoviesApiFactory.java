package com.example.tweetytube.core.di;

import com.example.tweetytube.features.movieList.data.remote.MoviesApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
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
public final class AppModule_ProvideMoviesApiFactory implements Factory<MoviesApi> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideMoviesApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MoviesApi get() {
    return provideMoviesApi(retrofitProvider.get());
  }

  public static AppModule_ProvideMoviesApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideMoviesApiFactory(retrofitProvider);
  }

  public static MoviesApi provideMoviesApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMoviesApi(retrofit));
  }
}
