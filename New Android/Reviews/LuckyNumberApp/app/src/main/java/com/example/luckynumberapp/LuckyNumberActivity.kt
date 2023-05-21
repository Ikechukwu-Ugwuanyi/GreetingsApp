package com.example.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val txtTitle : TextView = findViewById(R.id.textView2)
        val luckyNum : TextView = findViewById(R.id.luckyTxt)

        val btnShare: Button = findViewById(R.id.btnShare)

        var user_name = receiveUsername()

        var random_num = generateRandomNum()

        luckyNum.setText(""+random_num)
    }

    fun receiveUsername(): String {
        val bundle: Bundle? = intent.extras
        val userName = bundle?.get("name").toString()

        return userName
    }

    //Random Numbers Generator
    fun generateRandomNum(): Random {
        val random = Random(1000)
        return random
    }

    //Sharing
    fun shareData(username: String, num: Int) {
        var i = Intent(Intent.ACTION_SEND)
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today!")
        i.putExtra(Intent.EXTRA_TEXT, "His Lucky number is $num")
    }
}