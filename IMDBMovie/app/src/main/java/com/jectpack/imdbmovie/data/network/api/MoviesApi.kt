package com.jectpack.imdbmovie.data.network.api

import android.content.Context
import com.google.gson.Gson
import com.jectpack.imdbmovie.BuildConfig
import com.jectpack.imdbmovie.data.network.model.MovieDetialInfo
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.io.BufferedReader
import java.io.InputStreamReader


interface MoviesApi {
    @GET("/search")
    @Headers(
        "x-rapidapi-host:imdb-com.p.rapidapi.com",
        "x-rapidapi-key:${BuildConfig.API_KEY}"
    )
    suspend fun getMovies(
        @Query("searchTerm") searchTerm: String
    ): MovieDetialInfo

    suspend fun getMovieFromLocal(context: Context) : MovieDetialInfo{
        val jsonString = loadJSONFromAsset(context)
        return Gson().fromJson(jsonString, MovieDetialInfo::class.java)
    }


    private fun loadJSONFromAsset(context: Context): String {
        val jsonString = StringBuilder()
        try {
            val inputStream = context.assets.open("movie_details_info.json")
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                jsonString.append(line)
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return jsonString.toString()
    }
}
