package com.example.tweetytube.features.details.data.repo;

import com.example.tweetytube.features.details.data.local.CreditsDatabase;
import com.example.tweetytube.features.details.data.remote.CreditsApi;
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
public final class CreditsRepoImp_Factory implements Factory<CreditsRepoImp> {
  private final Provider<CreditsApi> creditsApiProvider;

  private final Provider<CreditsDatabase> creditsDatabaseProvider;

  public CreditsRepoImp_Factory(Provider<CreditsApi> creditsApiProvider,
      Provider<CreditsDatabase> creditsDatabaseProvider) {
    this.creditsApiProvider = creditsApiProvider;
    this.creditsDatabaseProvider = creditsDatabaseProvider;
  }

  @Override
  public CreditsRepoImp get() {
    return newInstance(creditsApiProvider.get(), creditsDatabaseProvider.get());
  }

  public static CreditsRepoImp_Factory create(Provider<CreditsApi> creditsApiProvider,
      Provider<CreditsDatabase> creditsDatabaseProvider) {
    return new CreditsRepoImp_Factory(creditsApiProvider, creditsDatabaseProvider);
  }

  public static CreditsRepoImp newInstance(CreditsApi creditsApi, CreditsDatabase creditsDatabase) {
    return new CreditsRepoImp(creditsApi, creditsDatabase);
  }
}
