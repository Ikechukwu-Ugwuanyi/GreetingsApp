package com.example.newretrofitapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)

        val retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData : LiveData<Response<Albums>> =
            liveData {
               // val response = retrofitService.getAlbums()

                val response2 = retrofitService.getSpecificAlbums(6)

                emit(response2)
            }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()

            if(albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    Log.i("TAG", albumItem.title)

                    val result = "Album Title: ${albumItem.title} \n"
                    textView.append(result)
                }
            }
        })

    }
}