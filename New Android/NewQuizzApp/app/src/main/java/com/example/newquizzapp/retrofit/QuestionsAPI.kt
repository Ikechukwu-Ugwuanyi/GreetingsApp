package com.example.newquizzapp.retrofit

import com.example.newquizzapp.model.QuestionsList
import retrofit2.Response
import retrofit2.http.GET

interface QuestionsAPI {
    @GET("multiplication.php")
    suspend fun getQuestions() : Response<QuestionsList>
}