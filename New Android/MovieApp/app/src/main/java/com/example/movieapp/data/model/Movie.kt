package com.example.movieapp.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity(tableName = "popular_movie" )
data class Movie (

    @SerializedName("id")
    val id : Int,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("title")
    val title: String
)