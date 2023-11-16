package com.example.quizapp.view

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


        //Adding functionality to the NEXT button
        var i = 1
        binding.apply{
            nextButton.setOnClickListener(View.OnClickListener {
                val selectedOption = radioGroup?.checkedRadioButtonId

                if(selectedOption != -1){
                    val radButton = findViewById<View>(selectedOption!!) as RadioButton

                    questionsList.let{
                        if(i < it.size) {

                            //Getting thr number of questions
                            totalQuestions = it.size
                            //Check if it is correct or not
                            if(radButton.text.toString().equals(it[i-1].correct_option)){
                                result++
                                textResult?.text = "Correct Answer : $result"
                            }

                            //Displaying the next questions
                            textQuestion.text = "Question ${i+1}: " + it[i].question
                            radio1.text = it[i].option1.toString()
                            radio2.text = it[i].option2.toString()
                            radio3.text = it[i].option3.toString()
                            radio4.text = it[i].option4.toString()

                            //Checking if it is the last question
                            if (i == it.size!!.minus(1)) {
                                nextButton.text = "FINISH"

                                radioGroup?.clearCheck()
                                i++

                            } else {
                                if (radButton.text.toString().equals(it[i-1].correct_option)){
                                    result++
                                    textResult?.text = "Correct Answer : $result"
                                } else {

                                }

                                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Please select an option", Toast.LENGTH_LONG)
                        .show()
                }
            })
        }


    }


}