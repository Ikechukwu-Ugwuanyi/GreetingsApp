package com.example.movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.model.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: List<Movie>)

    @Query("DELETE from popular_movie")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movie")
    suspend fun getAllMovie() : List<Movie>

}