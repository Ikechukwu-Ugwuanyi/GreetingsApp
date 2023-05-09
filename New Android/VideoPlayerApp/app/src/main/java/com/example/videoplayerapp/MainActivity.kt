package com.example.videoplayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Displaying videos from local storage
        val videoView : VideoView = findViewById(R.id.videoView1)
        videoView.setVideoPath("android.resource://" + packageName + "/" +R.raw.tafmun)

        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

        //Playing on app initiation
        videoView.start()


    }
}