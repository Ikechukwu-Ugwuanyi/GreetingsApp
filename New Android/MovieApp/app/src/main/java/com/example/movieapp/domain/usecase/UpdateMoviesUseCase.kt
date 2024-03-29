package com.example.movieapp.domain.usecase

import com.example.movieapp.data.model.Movie
import com.example.movieapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovie()
}