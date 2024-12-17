package com.example.tweetytube.core.di;

import com.example.tweetytube.features.details.data.remote.CreditsApi;
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
public final class AppModule_ProvideCreditsApiFactory implements Factory<CreditsApi> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideCreditsApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public CreditsApi get() {
    return provideCreditsApi(retrofitProvider.get());
  }

  public static AppModule_ProvideCreditsApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideCreditsApiFactory(retrofitProvider);
  }

  public static CreditsApi provideCreditsApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCreditsApi(retrofit));
  }
}
