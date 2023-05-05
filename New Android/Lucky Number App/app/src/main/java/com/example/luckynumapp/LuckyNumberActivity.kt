package com.example.luckynumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val text1: TextView = findViewById(R.id.text1)
        val text2: TextView = findViewById(R.id.text2)
        val btn: Button = findViewById(R.id.button)

        var user_name = recieveUsername()
//        Toast.makeText(this, ""+user_name,Toast.LENGTH_SHORT).show()

        val random_number = randomNumber()
        text2.setText(""+random_number)

        btn.setOnClickListener() {
            shareData(user_name, random_number)
        }
    }

    //Recieve Intents
    fun recieveUsername () : String{
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username

    }

    //Random Number Generator
    fun randomNumber() : Int {
        val random = Random().nextInt(1000)
        return random
    }

    //Sharing the Username and Numnber
    fun shareData(username: String, num: Int) {

        //Implicit Intent
        var intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is $num")

        startActivity(intent)

    }
}