package com.example.retrofitapp

import retrofit2.Retrofit

class RetrofitInstance {

    companion object{
        val BASE_URL = "Hhttps://jsonplaceholder.typicode.com"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder
        }
    }
}