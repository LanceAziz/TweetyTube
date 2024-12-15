package com.example.tweetytube.core.di

import android.app.Application
import androidx.room.Room
import com.example.tweetytube.core.utils.Urls.Companion.BASE_URL
import com.example.tweetytube.features.details.data.local.CreditsDatabase
import com.example.tweetytube.features.details.data.remote.CreditsApi
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
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun providesMovieApi(): MoviesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(MoviesApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCreditsApi(): CreditsApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(CreditsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "moviedb.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesCreditsDatabase(app: Application): CreditsDatabase {
        return Room.databaseBuilder(
            app,
            CreditsDatabase::class.java,
            "creditsdb.db"
        ).build()
    }

}




















