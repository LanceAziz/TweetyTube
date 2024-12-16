package com.example.tweetytube.core.di;

import com.example.tweetytube.features.details.data.remote.CreditsApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvidesCreditsApiFactory implements Factory<CreditsApi> {
  @Override
  public CreditsApi get() {
    return providesCreditsApi();
  }

  public static AppModule_ProvidesCreditsApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CreditsApi providesCreditsApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesCreditsApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvidesCreditsApiFactory INSTANCE = new AppModule_ProvidesCreditsApiFactory();
  }
}
