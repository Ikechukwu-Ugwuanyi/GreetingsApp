package com.example.videoplayerapp

import android.net.Uri
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

        //Video Display from the Internet
        val videoView2 : VideoView = findViewById(R.id.videoView2)

        //val uri : Uri = Uri.parse("https://youtu.be/BWXLqY2bEBA")
        videoView2.setVideoPath("https://static.videezy.com/system/resources/previous/002//231/original/5226496.mp4")

        val mediaController2 = MediaController(this)

        mediaController2.setAnchorView(videoView2)
        mediaController2.setMediaPlayer(videoView2)
        videoView2.setMediaController(mediaController2)
        videoView2.start()



    }
}