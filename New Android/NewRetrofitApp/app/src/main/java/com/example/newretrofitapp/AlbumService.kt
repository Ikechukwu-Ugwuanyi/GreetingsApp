package com.example.newretrofitapp

import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {


    //Endpoint Url
    @GET("/albums")
    suspend fun getAlbums() : Response<Albums>
}