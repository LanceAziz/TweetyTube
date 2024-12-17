package com.example.tweetytube.core.di;

import com.example.tweetytube.features.favorites.data.remote.FavoritesApi;
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
public final class AppModule_ProvideFavoritesApiFactory implements Factory<FavoritesApi> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideFavoritesApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public FavoritesApi get() {
    return provideFavoritesApi(retrofitProvider.get());
  }

  public static AppModule_ProvideFavoritesApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideFavoritesApiFactory(retrofitProvider);
  }

  public static FavoritesApi provideFavoritesApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideFavoritesApi(retrofit));
  }
}
