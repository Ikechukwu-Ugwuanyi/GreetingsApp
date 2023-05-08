package com.example.musicplayerapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    //Variables
    var startTime = 0.0
    var finalTime = 0.0
    var forwardTime = 10000
    var backwardTime = 10000
    var oneTimeOnly = 0

    //Handler
    var handler: Handler = Handler()

    //Media Player
    var mediaPlayer = MediaPlayer()
    lateinit var textTime: TextView
    lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn : Button = findViewById(R.id.play_icon)
        val pauseBtn : Button = findViewById(R.id.pauseBtn)
        val forwardBtn : Button = findViewById(R.id.btn_foward)
        val backButton : Button = findViewById(R.id.btn_back)

        val textTitle : TextView = findViewById(R.id.songTitle)
        textTime = findViewById(R.id.timeLeft)

        seekBar = findViewById(R.id.seekbar)

        mediaPlayer = MediaPlayer.create(
            this,
            R.raw.love_is_all
        )

        seekBar.isClickable = false

        playBtn.setOnClickListener() {
            mediaPlayer.start()
            finalTime = mediaPlayer.duration.toDouble()
            startTime = mediaPlayer.currentPosition.toDouble()
        }

        if(oneTimeOnly == 0) {
            seekBar.max = finalTime.toInt()
            oneTimeOnly = 1
        }

        textTime.text = startTime.toString()
        seekBar.setProgress(startTime.toInt())

       handler.postDelayed(UpdateSongTime, 100)

        //Creating the Runnable

        }

    val UpdateSongTime : Runnable = object :  Runnable {
        override fun run() {
            startTime = mediaPlayer.currentPosition.toDouble()
            textTime.text = "" + String.format(
                "%d min , %d sec",
                TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(startTime.toLong()
                        - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(
                        startTime.toLong()
                    )
                ))

            )

            seekBar.progress = startTime.toInt()
            handler.postDelayed(this, 100) //To delay tge seekbar

        }


    }


}