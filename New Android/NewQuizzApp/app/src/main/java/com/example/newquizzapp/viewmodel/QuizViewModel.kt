package com.example.newquizzapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newquizzapp.model.QuestionsList
import com.example.newquizzapp.repository.QuizRepository

class QuizViewModel :ViewModel() {

    var repository: QuizRepository = QuizRepository()
    lateinit var questionsLiveData: LiveData<QuestionsList>

    init {
        questionsLiveData = repository.getQuestionsFomAPI()
    }

    fun getQuestionsLivedata() : LiveData<QuestionsList>{
        return questionsLiveData
    }
}