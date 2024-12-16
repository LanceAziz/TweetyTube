package com.example.tweetytube.core.di;

import android.app.Application;
import com.example.tweetytube.features.details.data.local.CreditsDatabase;
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
public final class AppModule_ProvidesCreditsDatabaseFactory implements Factory<CreditsDatabase> {
  private final Provider<Application> appProvider;

  public AppModule_ProvidesCreditsDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public CreditsDatabase get() {
    return providesCreditsDatabase(appProvider.get());
  }

  public static AppModule_ProvidesCreditsDatabaseFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvidesCreditsDatabaseFactory(appProvider);
  }

  public static CreditsDatabase providesCreditsDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesCreditsDatabase(app));
  }
}
