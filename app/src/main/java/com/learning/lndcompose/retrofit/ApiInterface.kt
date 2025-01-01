package com.learning.lndcompose.retrofit

import com.learning.lndcompose.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(".")
    suspend fun getMovies(
        @Query("apikey")
        apiKey: String,
        @Query("page")
        page: String,
        @Query("s")
        searchParam: String,
    ): MovieResponse
}