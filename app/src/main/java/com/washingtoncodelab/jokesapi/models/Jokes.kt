package com.washingtoncodelab.jokesapi.models


import com.google.gson.annotations.SerializedName

class Jokes : ArrayList<Jokes.JokesItem>(){
    data class JokesItem(
        @SerializedName("id")
        val id: Int,
        @SerializedName("punchline")
        val punchline: String,
        @SerializedName("setup")
        val setup: String,
        @SerializedName("type")
        val type: String
    )
}