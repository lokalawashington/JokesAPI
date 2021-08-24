package com.washingtoncodelab.jokesapi.network

import com.washingtoncodelab.jokesapi.models.Jokes
import retrofit2.Call
import retrofit2.http.GET

interface JokesService {
    @GET("/jokes/ten")
    fun getJokes():Call<Jokes>
}