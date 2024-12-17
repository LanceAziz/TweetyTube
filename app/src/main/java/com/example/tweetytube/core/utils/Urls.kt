package com.example.tweetytube.core.utils

import com.example.tweetytube.BuildConfig

class Urls(){
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val INTIGRATION_LAYER_URL = "http://172.20.10.13:8280/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w342"
        const val MOVIES_API_KEY = BuildConfig.MOVIES_API_KEY
        const val INTEGRATION_API_KEY = BuildConfig.INTEGRATION_API_KEY
    }
}
