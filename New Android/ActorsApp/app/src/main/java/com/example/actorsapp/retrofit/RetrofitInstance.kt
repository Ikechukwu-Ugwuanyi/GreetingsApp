package com.example.actorsapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

        fun provideApi(builder: Retrofit.Builder) : CharacterApi{
            return builder
                .build()
                .create(CharacterApi::class.java)
        }

        fun provideRetrofit(): Retrofit.Builder {
            return Retrofit.Builder()
                .baseUrl("https://hp-api.onrender.com/api/")
                .addConverterFactory(GsonConverterFactory.create())

        }

}