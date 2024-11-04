package com.jectpack.imdbsimplenetwork.data.repository

import android.content.Context
import com.google.gson.Gson
import com.jectpack.imdbsimplenetwork.data.network.model.MovieDetailInfo
import com.jectpack.imdbsimplenetwork.common.RetrofitClient
import com.jectpack.imdbsimplenetwork.data.NetworkStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.isActive
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader


class MoviesApiRepo  {
    fun getMovies(search: String): Flow<NetworkStatus<MovieDetailInfo>> = flow {
        emit(NetworkStatus.Loading)
        try {
            emit(NetworkStatus.Success(RetrofitClient.movieApi.getMovies(search)))
        }catch (exception: Exception){
            emit(NetworkStatus.Failure(exception.message.toString(), exception))
        }

    }

      fun getMovieFromLocal(context: Context) : Flow<NetworkStatus<MovieDetailInfo>> = flow {
        emit(NetworkStatus.Loading)
         try {
             val movieDetailInfo = withContext(Dispatchers.IO) {
                 val jsonString = loadJSONFromAsset(context)
                 Gson().fromJson(jsonString, MovieDetailInfo::class.java)
             }
             emit(NetworkStatus.Success(movieDetailInfo))
         }catch (exception: Exception){
             emit(NetworkStatus.Failure(exception.message.toString(), exception))
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