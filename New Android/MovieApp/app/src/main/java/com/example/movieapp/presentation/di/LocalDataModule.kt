package com.example.movieapp.presentation.di

import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasourceimpl.MovieLocalDataSourceImpl
import com.example.movieapp.data.db.MovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }

}