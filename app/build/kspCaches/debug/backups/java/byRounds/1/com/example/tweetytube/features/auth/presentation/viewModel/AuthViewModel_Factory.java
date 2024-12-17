package com.example.tweetytube.features.auth.presentation.viewModel;

import com.example.tweetytube.features.auth.domain.repo.AuthRepo;
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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<AuthRepo> authRepoProvider;

  public AuthViewModel_Factory(Provider<AuthRepo> authRepoProvider) {
    this.authRepoProvider = authRepoProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(authRepoProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<AuthRepo> authRepoProvider) {
    return new AuthViewModel_Factory(authRepoProvider);
  }

  public static AuthViewModel newInstance(AuthRepo authRepo) {
    return new AuthViewModel(authRepo);
  }
}
