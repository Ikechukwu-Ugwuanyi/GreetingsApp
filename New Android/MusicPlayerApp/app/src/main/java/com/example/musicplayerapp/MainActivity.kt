package com.example.musicplayerapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
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
    lateinit var seekbar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn : Button = findViewById(R.id.play_icon)
        val pauseBtn : Button = findViewById(R.id.pauseBtn)
        val forwardBtn : Button = findViewById(R.id.btn_foward)
        val backButton : Button = findViewById(R.id.btn_back)

        val textTitle : TextView = findViewById(R.id.songTitle)
        textTime = findViewById(R.id.timeLeft)

        seekbar = findViewById(R.id.seekbar)

        mediaPlayer = MediaPlayer.create(
            this,
            R.raw.love_is_all
        )

        seekbar.isClickable = false

        playBtn.setOnClickListener() {
            mediaPlayer.start()
            finalTime = mediaPlayer.duration.toDouble()
            startTime = mediaPlayer.currentPosition.toDouble()
        }

        if(oneTimeOnly == 0) {
            seekbar.max = finalTime.toInt()
            oneTimeOnly = 1
        }

        textTime.text = startTime.toString()
        seekbar.setProgress(startTime.toInt())

       handler.postDelayed(UpdateSongTime, 100)

        //Setting the Music Title
        textTitle.text = "" + resources.getResourceEntryName(R.raw.love_is_all)

        //Stop Button
        pauseBtn.setOnClickListener() {
            mediaPlayer.pause()
        }

        //Forward Button
        forwardBtn.setOnClickListener() {
            var temp = startTime
            if ((temp + forwardTime) <= finalTime) {
                startTime = startTime + forwardTime
                mediaPlayer.seekTo(startTime.toInt())
            } else {
                Toast.makeText(this, "Cant't Jump Forward", Toast.LENGTH_LONG).show()
            }
        }

        //Backward Button

        backButton.setOnClickListener() {
            var temp = startTime.toInt()
            if ((temp - backwardTime) > 0) {
                startTime = startTime - backwardTime
                mediaPlayer.seekTo(startTime.toInt())
            } else {
                Toast.makeText(this, "Can't jump Backward", Toast.LENGTH_LONG).show()
            }
        }





    }





    //Creating the Runnable
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

            seekbar.progress = startTime.toInt()
            handler.postDelayed(this, 100) //To delay tge seekbar

        }


    }


}