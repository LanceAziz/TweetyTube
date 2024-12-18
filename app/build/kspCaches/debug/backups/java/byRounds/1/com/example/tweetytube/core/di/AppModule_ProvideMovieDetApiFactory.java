package com.example.tweetytube.core.di;

import com.example.tweetytube.features.actorDeatils.data.remote.MovieDetApi;
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
public final class AppModule_ProvideMovieDetApiFactory implements Factory<MovieDetApi> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideMovieDetApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MovieDetApi get() {
    return provideMovieDetApi(retrofitProvider.get());
  }

  public static AppModule_ProvideMovieDetApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideMovieDetApiFactory(retrofitProvider);
  }

  public static MovieDetApi provideMovieDetApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMovieDetApi(retrofit));
  }
}
