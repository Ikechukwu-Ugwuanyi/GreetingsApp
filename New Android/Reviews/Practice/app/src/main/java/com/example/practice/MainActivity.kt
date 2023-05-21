package com.example.practice

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    fun sayTheColor(view: View) {
//        val clickedBtn: Button = view as Button
//        val mediaPlayer:MediaPlayer = MediaPlayer.create(this,
//        resources.getIdentifier(clickedBtn.tag.toString(), "raw", packageName))
//        mediaPlayer.start()
//    }


}