package com.washingtoncodelab.jokesapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.washingtoncodelab.jokesapi.data.JokesRepository
import com.washingtoncodelab.jokesapi.models.Jokes

class MainViewModel : ViewModel() {
    val jokesRepositry = JokesRepository()
    val _reult :LiveData<Jokes>
        get() = jokesRepositry.results

    init {
        jokesRepositry.getAllJokes()
    }
}