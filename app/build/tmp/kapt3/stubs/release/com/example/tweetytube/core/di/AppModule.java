package com.example.tweetytube.core.di;

import android.app.Application;
import androidx.room.Room;
import com.example.tweetytube.features.details.data.local.CreditsDatabase;
import com.example.tweetytube.features.details.data.remote.CreditsApi;
import com.example.tweetytube.features.movieList.data.remote.MoviesApi;
import com.example.tweetytube.movie_list.data.repo.local.MovieDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/tweetytube/core/di/AppModule;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "interceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "providesCreditsApi", "Lcom/example/tweetytube/features/details/data/remote/CreditsApi;", "providesCreditsDatabase", "Lcom/example/tweetytube/features/details/data/local/CreditsDatabase;", "app", "Landroid/app/Application;", "providesMovieApi", "Lcom/example/tweetytube/features/movieList/data/remote/MoviesApi;", "providesMovieDatabase", "Lcom/example/tweetytube/movie_list/data/repo/local/MovieDatabase;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.logging.HttpLoggingInterceptor interceptor = null;
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.tweetytube.core.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.tweetytube.features.movieList.data.remote.MoviesApi providesMovieApi() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.tweetytube.features.details.data.remote.CreditsApi providesCreditsApi() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.tweetytube.movie_list.data.repo.local.MovieDatabase providesMovieDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.tweetytube.features.details.data.local.CreditsDatabase providesCreditsDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
}