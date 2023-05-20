package com.example.lessonreviews

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LIST VIEW REVIEW
        /*val listView : ListView = findViewById(R.id.listView)

        val states = arrayOf("Abuja", "Kogi", "Lagos", "Sokoto", "Enugu")

        val statesAdapter:BaseAdapter = ArrayAdapter(this, android.R.layout.simple_selectable_list_item, states)

        listView.adapter = statesAdapter
        */


        /*RECYCLER VIEW
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val myData = Datasource().loadAffirmations()

        val adapter = MyAdapter(myData)

        recyclerView.adapter = adapter */

        //Video Player
        val videoView: VideoView = findViewById(R.id.videoView)
        videoView.setVideoPath("android.resource://"+ packageName+"/" + R.raw.tafmun)

        val mediaController: MediaController = MediaController(this)
        mediaController.setMediaPlayer(videoView)
        mediaController.setAnchorView(videoView)

        videoView.setMediaController(mediaController)





    }
}