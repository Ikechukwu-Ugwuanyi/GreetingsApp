package com.example.actorsapppracticde2.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun provideApi(builder: Retrofit.Builder) : CharacterApi {
        return builder
            .build()
            .create(CharacterApi::class.java)
    }

    fun getRetrofitInstance() : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
    }
}