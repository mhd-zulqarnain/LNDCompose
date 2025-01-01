package com.learning.lndcompose.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiInterface by lazy {
        val retrofit = Retrofit.Builder().baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        retrofit.create(ApiInterface::class.java)
    }
}