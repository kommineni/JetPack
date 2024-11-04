package com.jectpack.imdbsimplenetwork.data.network.service

import com.jectpack.imdbsimplenetwork.data.network.model.MovieDetailInfo
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi  {

    @GET("/search")
    @Headers(
        "x-rapidapi-host:imdb-com.p.rapidapi.com",
        "x-rapidapi-key:53b6d8e1ccmsh9ba7ea25be97644p1a50dfjsnc7ef4088106d"
    )
    suspend fun getMovies(
        @Query("searchTerm") search:String
    ): MovieDetailInfo
}