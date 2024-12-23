package com.example.tweetytube;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.tweetytube.core.di.AppModule_ProvideAuthApiFactory;
import com.example.tweetytube.core.di.AppModule_ProvideAuthRepoFactory;
import com.example.tweetytube.core.di.AppModule_ProvideAuthRetrofitFactory;
import com.example.tweetytube.core.di.AppModule_ProvideCreditsApiFactory;
import com.example.tweetytube.core.di.AppModule_ProvideCreditsDatabaseFactory;
import com.example.tweetytube.core.di.AppModule_ProvideFavoritesApiFactory;
import com.example.tweetytube.core.di.AppModule_ProvideFavoritesRepoFactory;
import com.example.tweetytube.core.di.AppModule_ProvideMovieDatabaseFactory;
import com.example.tweetytube.core.di.AppModule_ProvideMovieDetApiFactory;
import com.example.tweetytube.core.di.AppModule_ProvideMovieDetDatabaseFactory;
import com.example.tweetytube.core.di.AppModule_ProvideMovieDetRepoFactory;
import com.example.tweetytube.core.di.AppModule_ProvideMoviesApiFactory;
import com.example.tweetytube.core.di.AppModule_ProvideOkHttpClientFactory;
import com.example.tweetytube.core.di.AppModule_ProvideRetrofitFactory;
import com.example.tweetytube.features.actorDeatils.data.local.MovieDetDatabase;
import com.example.tweetytube.features.actorDeatils.data.remote.MovieDetApi;
import com.example.tweetytube.features.actorDeatils.domain.repo.MovieDetRepo;
import com.example.tweetytube.features.actorDeatils.presentation.viewModel.ActorDetailsViewModel;
import com.example.tweetytube.features.actorDeatils.presentation.viewModel.ActorDetailsViewModel_HiltModules;
import com.example.tweetytube.features.actorDeatils.presentation.viewModel.ActorDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.tweetytube.features.actorDeatils.presentation.viewModel.ActorDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.tweetytube.features.auth.data.remote.AuthApi;
import com.example.tweetytube.features.auth.domain.repo.AuthRepo;
import com.example.tweetytube.features.auth.presentation.viewModel.AuthViewModel;
import com.example.tweetytube.features.auth.presentation.viewModel.AuthViewModel_HiltModules;
import com.example.tweetytube.features.auth.presentation.viewModel.AuthViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.tweetytube.features.auth.presentation.viewModel.AuthViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.tweetytube.features.details.data.local.CreditsDatabase;
import com.example.tweetytube.features.details.data.remote.CreditsApi;
import com.example.tweetytube.features.details.data.repo.CreditsRepoImp;
import com.example.tweetytube.features.details.domain.repo.CreditsRepo;
import com.example.tweetytube.features.details.presentation.viewModel.DetailsViewModel;
import com.example.tweetytube.features.details.presentation.viewModel.DetailsViewModel_HiltModules;
import com.example.tweetytube.features.details.presentation.viewModel.DetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.tweetytube.features.details.presentation.viewModel.DetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.tweetytube.features.favorites.data.remote.FavoritesApi;
import com.example.tweetytube.features.favorites.domain.repo.FavoritesRepo;
import com.example.tweetytube.features.favorites.presentation.viewModel.FavoritesViewModel;
import com.example.tweetytube.features.favorites.presentation.viewModel.FavoritesViewModel_HiltModules;
import com.example.tweetytube.features.favorites.presentation.viewModel.FavoritesViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.tweetytube.features.favorites.presentation.viewModel.FavoritesViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.tweetytube.features.movieList.data.remote.MoviesApi;
import com.example.tweetytube.features.movieList.data.repo.MovieListRepoImp;
import com.example.tweetytube.features.movieList.domain.repo.MovieListRepo;
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel;
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel_HiltModules;
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.tweetytube.movie_list.data.repo.local.MovieDatabase;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class DaggerApp_HiltComponents_SingletonC {
  private DaggerApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public App_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements App_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public App_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements App_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public App_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements App_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public App_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements App_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public App_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements App_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public App_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements App_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public App_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements App_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public App_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends App_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends App_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends App_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends App_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(5).put(ActorDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ActorDetailsViewModel_HiltModules.KeyModule.provide()).put(AuthViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AuthViewModel_HiltModules.KeyModule.provide()).put(DetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, DetailsViewModel_HiltModules.KeyModule.provide()).put(FavoritesViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, FavoritesViewModel_HiltModules.KeyModule.provide()).put(MovieListViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, MovieListViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends App_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<ActorDetailsViewModel> actorDetailsViewModelProvider;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<DetailsViewModel> detailsViewModelProvider;

    private Provider<FavoritesViewModel> favoritesViewModelProvider;

    private Provider<MovieListViewModel> movieListViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.actorDetailsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.detailsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.favoritesViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.movieListViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(5).put(ActorDetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) actorDetailsViewModelProvider)).put(AuthViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) authViewModelProvider)).put(DetailsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) detailsViewModelProvider)).put(FavoritesViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) favoritesViewModelProvider)).put(MovieListViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) movieListViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.example.tweetytube.features.actorDeatils.presentation.viewModel.ActorDetailsViewModel 
          return (T) new ActorDetailsViewModel(singletonCImpl.provideMovieDetRepoProvider.get());

          case 1: // com.example.tweetytube.features.auth.presentation.viewModel.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.provideAuthRepoProvider.get());

          case 2: // com.example.tweetytube.features.details.presentation.viewModel.DetailsViewModel 
          return (T) new DetailsViewModel(singletonCImpl.bindMovieListRepositoryProvider.get(), singletonCImpl.bindCreditsRepositoryProvider.get());

          case 3: // com.example.tweetytube.features.favorites.presentation.viewModel.FavoritesViewModel 
          return (T) new FavoritesViewModel(singletonCImpl.provideFavoritesRepoProvider.get());

          case 4: // com.example.tweetytube.features.movieList.presentation.viewModel.MovieListViewModel 
          return (T) new MovieListViewModel(singletonCImpl.bindMovieListRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends App_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends App_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends App_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<MovieDetApi> provideMovieDetApiProvider;

    private Provider<MovieDetDatabase> provideMovieDetDatabaseProvider;

    private Provider<MovieDetRepo> provideMovieDetRepoProvider;

    private Provider<Retrofit> provideAuthRetrofitProvider;

    private Provider<AuthApi> provideAuthApiProvider;

    private Provider<AuthRepo> provideAuthRepoProvider;

    private Provider<MoviesApi> provideMoviesApiProvider;

    private Provider<MovieDatabase> provideMovieDatabaseProvider;

    private Provider<MovieListRepoImp> movieListRepoImpProvider;

    private Provider<MovieListRepo> bindMovieListRepositoryProvider;

    private Provider<CreditsApi> provideCreditsApiProvider;

    private Provider<CreditsDatabase> provideCreditsDatabaseProvider;

    private Provider<CreditsRepoImp> creditsRepoImpProvider;

    private Provider<CreditsRepo> bindCreditsRepositoryProvider;

    private Provider<FavoritesApi> provideFavoritesApiProvider;

    private Provider<FavoritesRepo> provideFavoritesRepoProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 3));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 2));
      this.provideMovieDetApiProvider = DoubleCheck.provider(new SwitchingProvider<MovieDetApi>(singletonCImpl, 1));
      this.provideMovieDetDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<MovieDetDatabase>(singletonCImpl, 4));
      this.provideMovieDetRepoProvider = DoubleCheck.provider(new SwitchingProvider<MovieDetRepo>(singletonCImpl, 0));
      this.provideAuthRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 7));
      this.provideAuthApiProvider = DoubleCheck.provider(new SwitchingProvider<AuthApi>(singletonCImpl, 6));
      this.provideAuthRepoProvider = DoubleCheck.provider(new SwitchingProvider<AuthRepo>(singletonCImpl, 5));
      this.provideMoviesApiProvider = DoubleCheck.provider(new SwitchingProvider<MoviesApi>(singletonCImpl, 9));
      this.provideMovieDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<MovieDatabase>(singletonCImpl, 10));
      this.movieListRepoImpProvider = new SwitchingProvider<>(singletonCImpl, 8);
      this.bindMovieListRepositoryProvider = DoubleCheck.provider((Provider) movieListRepoImpProvider);
      this.provideCreditsApiProvider = DoubleCheck.provider(new SwitchingProvider<CreditsApi>(singletonCImpl, 12));
      this.provideCreditsDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<CreditsDatabase>(singletonCImpl, 13));
      this.creditsRepoImpProvider = new SwitchingProvider<>(singletonCImpl, 11);
      this.bindCreditsRepositoryProvider = DoubleCheck.provider((Provider) creditsRepoImpProvider);
      this.provideFavoritesApiProvider = DoubleCheck.provider(new SwitchingProvider<FavoritesApi>(singletonCImpl, 15));
      this.provideFavoritesRepoProvider = DoubleCheck.provider(new SwitchingProvider<FavoritesRepo>(singletonCImpl, 14));
    }

    @Override
    public void injectApp(App app) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.example.tweetytube.features.actorDeatils.domain.repo.MovieDetRepo 
          return (T) AppModule_ProvideMovieDetRepoFactory.provideMovieDetRepo(singletonCImpl.provideMovieDetApiProvider.get(), singletonCImpl.provideMovieDetDatabaseProvider.get());

          case 1: // com.example.tweetytube.features.actorDeatils.data.remote.MovieDetApi 
          return (T) AppModule_ProvideMovieDetApiFactory.provideMovieDetApi(singletonCImpl.provideRetrofitProvider.get());

          case 2: // @javax.inject.Named("GeneralRetrofit") retrofit2.Retrofit 
          return (T) AppModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.provideOkHttpClientProvider.get());

          case 3: // okhttp3.OkHttpClient 
          return (T) AppModule_ProvideOkHttpClientFactory.provideOkHttpClient();

          case 4: // com.example.tweetytube.features.actorDeatils.data.local.MovieDetDatabase 
          return (T) AppModule_ProvideMovieDetDatabaseFactory.provideMovieDetDatabase(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 5: // com.example.tweetytube.features.auth.domain.repo.AuthRepo 
          return (T) AppModule_ProvideAuthRepoFactory.provideAuthRepo(singletonCImpl.provideAuthApiProvider.get());

          case 6: // com.example.tweetytube.features.auth.data.remote.AuthApi 
          return (T) AppModule_ProvideAuthApiFactory.provideAuthApi(singletonCImpl.provideAuthRetrofitProvider.get());

          case 7: // @javax.inject.Named("AuthRetrofit") retrofit2.Retrofit 
          return (T) AppModule_ProvideAuthRetrofitFactory.provideAuthRetrofit(singletonCImpl.provideOkHttpClientProvider.get());

          case 8: // com.example.tweetytube.features.movieList.data.repo.MovieListRepoImp 
          return (T) new MovieListRepoImp(singletonCImpl.provideMoviesApiProvider.get(), singletonCImpl.provideMovieDatabaseProvider.get());

          case 9: // com.example.tweetytube.features.movieList.data.remote.MoviesApi 
          return (T) AppModule_ProvideMoviesApiFactory.provideMoviesApi(singletonCImpl.provideRetrofitProvider.get());

          case 10: // com.example.tweetytube.movie_list.data.repo.local.MovieDatabase 
          return (T) AppModule_ProvideMovieDatabaseFactory.provideMovieDatabase(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 11: // com.example.tweetytube.features.details.data.repo.CreditsRepoImp 
          return (T) new CreditsRepoImp(singletonCImpl.provideCreditsApiProvider.get(), singletonCImpl.provideCreditsDatabaseProvider.get());

          case 12: // com.example.tweetytube.features.details.data.remote.CreditsApi 
          return (T) AppModule_ProvideCreditsApiFactory.provideCreditsApi(singletonCImpl.provideRetrofitProvider.get());

          case 13: // com.example.tweetytube.features.details.data.local.CreditsDatabase 
          return (T) AppModule_ProvideCreditsDatabaseFactory.provideCreditsDatabase(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 14: // com.example.tweetytube.features.favorites.domain.repo.FavoritesRepo 
          return (T) AppModule_ProvideFavoritesRepoFactory.provideFavoritesRepo(singletonCImpl.provideFavoritesApiProvider.get());

          case 15: // com.example.tweetytube.features.favorites.data.remote.FavoritesApi 
          return (T) AppModule_ProvideFavoritesApiFactory.provideFavoritesApi(singletonCImpl.provideAuthRetrofitProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
