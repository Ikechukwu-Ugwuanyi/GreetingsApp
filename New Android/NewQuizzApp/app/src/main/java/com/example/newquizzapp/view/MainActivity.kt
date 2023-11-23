package com.example.newquizzapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
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

        //Displaying the rest of the questions
        var i = 1
        binding.apply {
            nextButton.setOnClickListener(View.OnClickListener {
                val selectedButton = radioGroup.checkedRadioButtonId
                if (selectedButton != -1){
                    val radButton = findViewById<View>(selectedButton) as RadioButton

                    questionsList.let{
                        if(i < it.size){

                            //Getting the number of questions
                            totalQuestion = it.size
                        }

                        //Check if it is correct or not
                        if (radButton.text.toString().equals(it[i-1].correct_option)){
                            result++
                            correctText.text = "Correct Answer $result"
                        }

                        //Displaying the next question
                        questionText.text = "Question ${i+1}: "+ it[i].question
                        radio1.text = it[i].option1
                        radio2.text = it[i].option2
                        radio3.text = it[i].option3
                        radio4.text = it[i].option4

                        //Checking if it is the last question
                        if (i == it.size.minus(1)){
                            nextButton.text = "FINISH"

                            radioGroup.clearCheck()
                            i++

                        } else {
                            if (radButton.text.toString().equals(it[1-1].correct_option)){
                                result++
                                correctText.text= "Correct Answer: $result"
                            } else {

                            }

                            val intent = Intent(this@MainActivity, ResultActivity::class.java)
                            startActivity(intent)
                            finish()

                        }
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Please select an option", Toast.LENGTH_LONG).show()
                }
            })

        }

    }
}