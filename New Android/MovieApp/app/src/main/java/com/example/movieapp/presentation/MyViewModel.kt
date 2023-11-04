package com.example.movieapp.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.domain.usecase.GetMoviesUseCase
import com.example.movieapp.domain.usecase.UpdateMoviesUseCase

class MyViewModel(private  val getMoviesUseCase: GetMoviesUseCase,
                  private  val updateMoviesUseCase: UpdateMoviesUseCase) : ViewModel() {


    fun getMovie() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovie() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}