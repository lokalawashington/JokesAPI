package com.washingtoncodelab.jokesapi.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.washingtoncodelab.jokesapi.models.Jokes
import com.washingtoncodelab.jokesapi.network.JokesAPI
import retrofit2.Call
import retrofit2.Response

private const val TAG = "JokesRepository"
class JokesRepository {
    
    val results = MutableLiveData<Jokes>()
    
    fun getAllJokes(){
        JokesAPI.retrofitService.getJokes().enqueue(object : retrofit2.Callback<Jokes>{
            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {
                results.value = response.body()
                Log.d(TAG, "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.localizedMessage}")
            }


        })
    }
}