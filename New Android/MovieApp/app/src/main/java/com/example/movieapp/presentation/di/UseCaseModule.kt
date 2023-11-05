package com.example.movieapp.presentation.di

import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.domain.usecase.GetMoviesUseCase
import com.example.movieapp.domain.usecase.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun updateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }
}