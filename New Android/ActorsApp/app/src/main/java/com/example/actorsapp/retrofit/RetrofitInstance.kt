package com.example.actorsapp.retrofit

import com.squareup.moshi.Moshi
import retrofit2.Retrofit

object RetrofitInstance {

    fun provideApi(builder: Retrofit.Builder) : CharacterApi{
        return builder
            .build()
            .create(CharacterApi::class.java)
    }

    fun provideRetrofit(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
    }
}