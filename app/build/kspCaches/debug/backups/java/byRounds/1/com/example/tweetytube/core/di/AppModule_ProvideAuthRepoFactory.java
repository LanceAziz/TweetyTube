package com.example.tweetytube.core.di;

import com.example.tweetytube.features.auth.data.remote.AuthApi;
import com.example.tweetytube.features.auth.domain.repo.AuthRepo;
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
public final class AppModule_ProvideAuthRepoFactory implements Factory<AuthRepo> {
  private final Provider<AuthApi> authApiProvider;

  public AppModule_ProvideAuthRepoFactory(Provider<AuthApi> authApiProvider) {
    this.authApiProvider = authApiProvider;
  }

  @Override
  public AuthRepo get() {
    return provideAuthRepo(authApiProvider.get());
  }

  public static AppModule_ProvideAuthRepoFactory create(Provider<AuthApi> authApiProvider) {
    return new AppModule_ProvideAuthRepoFactory(authApiProvider);
  }

  public static AuthRepo provideAuthRepo(AuthApi authApi) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthRepo(authApi));
  }
}
