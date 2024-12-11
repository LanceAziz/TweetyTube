package com.example.tweetytube.core.utils

import com.example.tweetytube.BuildConfig

class Urls(){
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w342"
        const val MOVIES_API_KEY = BuildConfig.MOVIES_API_KEY
    }
}
