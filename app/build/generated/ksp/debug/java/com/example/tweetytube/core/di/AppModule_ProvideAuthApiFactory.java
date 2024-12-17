package com.example.tweetytube.core.di;

import com.example.tweetytube.features.auth.data.remote.AuthApi;
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
public final class AppModule_ProvideAuthApiFactory implements Factory<AuthApi> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideAuthApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public AuthApi get() {
    return provideAuthApi(retrofitProvider.get());
  }

  public static AppModule_ProvideAuthApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideAuthApiFactory(retrofitProvider);
  }

  public static AuthApi provideAuthApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthApi(retrofit));
  }
}
