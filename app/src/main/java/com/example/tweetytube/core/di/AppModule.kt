package com.example.tweetytube.core.di

import android.app.Application
import androidx.room.Room
import com.example.tweetytube.core.utils.Urls.Companion.BASE_URL
import com.example.tweetytube.core.utils.Urls.Companion.INTIGRATION_LAYER_URL
import com.example.tweetytube.features.actorDeatils.data.local.MovieDetDatabase
import com.example.tweetytube.features.actorDeatils.data.remote.MovieDetApi
import com.example.tweetytube.features.actorDeatils.data.repo.MovieDetRepoImp
import com.example.tweetytube.features.actorDeatils.domain.repo.MovieDetRepo
import com.example.tweetytube.features.auth.data.remote.AuthApi
import com.example.tweetytube.features.auth.data.repo.AuthRepoImp
import com.example.tweetytube.features.auth.domain.repo.AuthRepo
import com.example.tweetytube.features.details.data.local.CreditsDatabase
import com.example.tweetytube.features.details.data.remote.CreditsApi
import com.example.tweetytube.features.favorites.data.remote.FavoritesApi
import com.example.tweetytube.features.favorites.data.repo.FavoritesRepoImp
import com.example.tweetytube.features.favorites.domain.repo.FavoritesRepo
import com.example.tweetytube.features.movieList.data.remote.MoviesApi
import com.example.tweetytube.movie_list.data.repo.local.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // 1. Provide OkHttpClient
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    // 2. Provide Retrofit for General APIs
    @Provides
    @Singleton
    @Named("GeneralRetrofit")
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL) // General base URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    // 3. Provide Retrofit for Auth and Favorites APIs
    @Provides
    @Singleton
    @Named("AuthRetrofit")
    fun provideAuthRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(INTIGRATION_LAYER_URL) // Auth-specific base URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    // 4. Provide APIs using Named Retrofit Instances
    @Provides
    @Singleton
    fun provideMoviesApi(@Named("GeneralRetrofit") retrofit: Retrofit): MoviesApi =
        retrofit.create(MoviesApi::class.java)

    @Provides
    @Singleton
    fun provideCreditsApi(@Named("GeneralRetrofit") retrofit: Retrofit): CreditsApi =
        retrofit.create(CreditsApi::class.java)

    @Provides
    @Singleton
    fun provideAuthApi(@Named("AuthRetrofit") retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideFavoritesApi(@Named("AuthRetrofit") retrofit: Retrofit): FavoritesApi =
        retrofit.create(FavoritesApi::class.java)

    @Provides
    @Singleton
    fun provideMovieDetApi(@Named("GeneralRetrofit") retrofit: Retrofit): MovieDetApi =
        retrofit.create(MovieDetApi::class.java)

    // 5. Provide Repos
    @Provides
    @Singleton
    fun provideAuthRepo(authApi: AuthApi): AuthRepo = AuthRepoImp(authApi)

    @Provides
    @Singleton
    fun provideFavoritesRepo(favoritesApi: FavoritesApi): FavoritesRepo =
        FavoritesRepoImp(favoritesApi)

    @Provides
    @Singleton
    fun provideMovieDetRepo(
        movieDetApi: MovieDetApi,
        movieDetDatabase: MovieDetDatabase
    ): MovieDetRepo = MovieDetRepoImp(movieDetApi, movieDetDatabase)

    // 6. Provide Room Databases
    @Provides
    @Singleton
    fun provideMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "moviedb.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCreditsDatabase(app: Application): CreditsDatabase {
        return Room.databaseBuilder(
            app,
            CreditsDatabase::class.java,
            "creditsdb.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDetDatabase(app: Application): MovieDetDatabase {
        return Room.databaseBuilder(
            app,
            MovieDetDatabase::class.java,
            "moviedetdb.db"
        ).build()
    }
}
