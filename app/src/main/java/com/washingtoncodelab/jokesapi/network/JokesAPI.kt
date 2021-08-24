package com.washingtoncodelab.jokesapi.network

import com.washingtoncodelab.jokesapi.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokesAPI {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService by lazy {
        retrofit.create(JokesService::class.java)
    }
}