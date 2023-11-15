package com.example.quizapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.model.Questions
import com.example.quizapp.viewmodel.QuizViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var quizViewModel: QuizViewModel
    lateinit var questionsList: List<Questions>

    companion object {
        var result = 0
        var totalQuestions = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Resetting the scores
        result = 0
        totalQuestions = 0

        quizViewModel = ViewModelProvider(this)
            .get(QuizViewModel::class.java)

        //Getting the first question
        GlobalScope.launch(Dispatchers.Main) {
            quizViewModel.getQuestionsFromLiveData().observe(this@MainActivity, Observer {
                if(it.size > 0) {
                    questionsList = it
                    Log.i("TAG", "This is the first question: ${questionsList[0]}")

                    binding.apply {
                        textQuestion.text = questionsList!![0].question
                        radio1.text = questionsList!![0].option1.toString()
                        radio2.text = questionsList!![0].option2.toString()
                        radio3.text = questionsList!![0].option3.toString()
                        radio4.text = questionsList!![0].option4.toString()
                    }

                }
            })
        }
    }


}