package com.example.newquizzapp.retrofit

import retrofit2.Retrofit

class RetrofitInstance {

    val baseUrl = "http://192.168.0.149/quiz"

    suspend fun getRetrofitInstance() :  Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}