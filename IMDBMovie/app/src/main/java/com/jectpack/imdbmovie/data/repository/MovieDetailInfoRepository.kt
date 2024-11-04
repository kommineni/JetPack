package com.jectpack.imdbmovie.data.repository

import android.content.Context
import com.google.gson.Gson
import com.jectpack.imdbmovie.data.network.NetworkStatus
import com.jectpack.imdbmovie.data.network.RetrofitClient
import com.jectpack.imdbmovie.data.network.api.MoviesApi
import com.jectpack.imdbmovie.data.network.model.MovieDetialInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader

class MovieDetailInfoRepository {
    private val movieApi = RetrofitClient.createService(MoviesApi::class.java)

     fun getMovies(searchTerm: String, context: Context): Flow<NetworkStatus<MovieDetialInfo>> = flow {
        emit(NetworkStatus.Loading)
        try {
            emit(NetworkStatus.Success(movieApi.getMovies("all")))
        }catch (exception: Exception){
            emit(NetworkStatus.Failure(exception.message ?: "Unknown Error"))
        }
    }


     suspend fun getMovieFromLocal(context: Context) : MovieDetialInfo{
         return withContext(Dispatchers.IO) {
             val jsonString = loadJSONFromAsset(context)
          Gson().fromJson(jsonString, MovieDetialInfo::class.java)
         }
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