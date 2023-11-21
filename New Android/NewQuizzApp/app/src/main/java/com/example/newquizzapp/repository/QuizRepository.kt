package com.example.newquizzapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newquizzapp.model.QuestionsList
import com.example.newquizzapp.retrofit.QuestionsAPI
import com.example.newquizzapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuizRepository {

    var questionsAPI: QuestionsAPI

    init {
        questionsAPI = RetrofitInstance().getRetrofitInstance()
            .create(QuestionsAPI::class.java)
    }

    fun getQuestionsFomAPI(): LiveData<QuestionsList> {
        var data = MutableLiveData<QuestionsList>()
        var questionsList: QuestionsList

        GlobalScope.launch(Dispatchers.IO) {
            //Returning a response
            val response = questionsAPI.getQuestions()

            if (response != null) {

                //Saving the data to List
                questionsList = response.body()!!

                data.postValue(questionsList)
                Log.i("TAG", "" + data.value)
            }
        }

        return data
    }

}