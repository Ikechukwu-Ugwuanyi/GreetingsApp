package com.example.movieapp.presentation.di

import com.example.movieapp.domain.usecase.GetMoviesUseCase
import com.example.movieapp.domain.usecase.UpdateMoviesUseCase
import com.example.movieapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {
        return ViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}