package com.example.lessonreviews

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.french_sounds)
    }

    //French Teacher App

    fun sayTheColor(view : View) {
        var clickedButton : Button = view as Button

        var mediaPlayer: MediaPlayer = MediaPlayer.create(
            this,
            resources.getIdentifier(
                clickedButton.tag.toString(),
                "raw",
                packageName
            )
        )

        mediaPlayer.start()
    }

}