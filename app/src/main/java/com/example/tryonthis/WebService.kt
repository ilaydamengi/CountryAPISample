package com.example.tryonthis

import com.example.tryonthis.model.Country
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("all")
    fun getCountry(): Call<List<Country>>

   companion object {

        private var BASE_URL = "https://restcountries.eu/rest/v2/"

        fun create(): WebService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(WebService::class.java)
        }
       }
    }