package com.example.tweetytube.core.di;

import com.example.tweetytube.features.favorites.data.remote.FavoritesApi;
import com.example.tweetytube.features.favorites.domain.repo.FavoritesRepo;
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
public final class AppModule_ProvideFavoritesRepoFactory implements Factory<FavoritesRepo> {
  private final Provider<FavoritesApi> favoritesApiProvider;

  public AppModule_ProvideFavoritesRepoFactory(Provider<FavoritesApi> favoritesApiProvider) {
    this.favoritesApiProvider = favoritesApiProvider;
  }

  @Override
  public FavoritesRepo get() {
    return provideFavoritesRepo(favoritesApiProvider.get());
  }

  public static AppModule_ProvideFavoritesRepoFactory create(
      Provider<FavoritesApi> favoritesApiProvider) {
    return new AppModule_ProvideFavoritesRepoFactory(favoritesApiProvider);
  }

  public static FavoritesRepo provideFavoritesRepo(FavoritesApi favoritesApi) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideFavoritesRepo(favoritesApi));
  }
}
