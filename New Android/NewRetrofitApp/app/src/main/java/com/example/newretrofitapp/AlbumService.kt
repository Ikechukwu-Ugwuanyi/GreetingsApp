package com.example.newretrofitapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    //Endpoint Url
    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>

    @GET("/albums")
    suspend fun getSpecificAlbums(@Query("userId") userId: Int): Response<Albums>
}