package com.example.tweetytube.features.favorites.presentation.viewModel;

import com.example.tweetytube.features.favorites.domain.repo.FavoritesRepo;
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
public final class FavoritesViewModel_Factory implements Factory<FavoritesViewModel> {
  private final Provider<FavoritesRepo> favoritesRepoProvider;

  public FavoritesViewModel_Factory(Provider<FavoritesRepo> favoritesRepoProvider) {
    this.favoritesRepoProvider = favoritesRepoProvider;
  }

  @Override
  public FavoritesViewModel get() {
    return newInstance(favoritesRepoProvider.get());
  }

  public static FavoritesViewModel_Factory create(Provider<FavoritesRepo> favoritesRepoProvider) {
    return new FavoritesViewModel_Factory(favoritesRepoProvider);
  }

  public static FavoritesViewModel newInstance(FavoritesRepo favoritesRepo) {
    return new FavoritesViewModel(favoritesRepo);
  }
}
