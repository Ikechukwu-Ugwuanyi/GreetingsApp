package com.example.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Math.random
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

        btnShare.setOnClickListener() {
            shareData(user_name, random_num)
        }

    }

    fun receiveUsername(): String {
        val bundle: Bundle? = intent.extras
        val userName = bundle?.get("name").toString()

        return userName
    }

    //Random Numbers Generator
    fun generateRandomNum(): Int {
        val random  = Random().nextInt(1000)
        return random
    }

    //Sharing
    fun shareData(username: String, num: Int) {
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today!")
        i.putExtra(Intent.EXTRA_TEXT, "His Lucky number is $num")
        startActivity(i)
    }
}