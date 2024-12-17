package com.example.tweetytube.core.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
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
public final class AppModule_ProvideAuthRetrofitFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> clientProvider;

  public AppModule_ProvideAuthRetrofitFactory(Provider<OkHttpClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {
    return provideAuthRetrofit(clientProvider.get());
  }

  public static AppModule_ProvideAuthRetrofitFactory create(Provider<OkHttpClient> clientProvider) {
    return new AppModule_ProvideAuthRetrofitFactory(clientProvider);
  }

  public static Retrofit provideAuthRetrofit(OkHttpClient client) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthRetrofit(client));
  }
}
