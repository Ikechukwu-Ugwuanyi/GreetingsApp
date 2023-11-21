package com.example.newquizzapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newquizzapp.R
import com.example.newquizzapp.databinding.ActivityMainBinding
import com.example.newquizzapp.model.QuestionsList
import com.example.newquizzapp.viewmodel.QuizViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var quizViewModel: QuizViewModel
    lateinit var questionsList: QuestionsList

    companion object{
        var result = 0
        var totalQuestion = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Resetting the scores
        result = 0
        totalQuestion= 0

        //Getting the response
        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        //Displaying the first question
        GlobalScope.launch(Dispatchers.Main) {
            quizViewModel.getQuestionsLivedata().observe(this@MainActivity, Observer {
                if(it.size > 0){
                    questionsList = it
                    Log.i("TAG", "The first question is: ${questionsList[0]}")

                    binding.apply {
                        questionText.text = questionsList[0].question
                        radio1.text = questionsList[1].option1
                        radio2.text = questionsList[2].option2
                        radio3.text = questionsList[3].option3
                        radio4.text = questionsList[4].option4
                    }
                }
            })
        }

    }
}