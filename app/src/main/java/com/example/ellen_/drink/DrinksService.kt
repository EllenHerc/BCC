package com.example.ellen_.drink

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksService {

    companion object {
        private const val API_KEY = ""
    }

    @GET("filter.php?")
    fun getFilter(@Query("a") filter: String = "Alcoholic"): Call<DrinkList>

    @GET("lookup.php?")
    fun getId(@Query("i") id: String): Call<DrinkList>

}