package com.jectpack.imdbsimplenetwork.common

import com.jectpack.imdbsimplenetwork.data.network.service.MoviesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

object RetrofitClient {

    val  BASE_URL = "https://imdb-com.p.rapidapi.com/";

    val retrofitClient = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    val movieApi = retrofitClient.create(MoviesApi::class.java)
}
private fun getHttpClient() =
    OkHttpClient.Builder()
        .addInterceptor(interceptor())
        .readTimeout(30, SECONDS)
        .callTimeout(30, SECONDS)
        .build()

private fun interceptor() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

