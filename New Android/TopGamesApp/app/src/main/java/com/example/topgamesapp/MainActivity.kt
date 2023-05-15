package com.example.topgamesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. Adapter View -> Recyclerview(cardView)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,
        LinearLayoutManager.VERTICAL, false)

        //2. Data Source : List of Games
        var gameList: ArrayList<GameModel> = ArrayList()

        val g1 = GameModel(R.drawable.game, "Horizon Chase")
        val g2 = GameModel(R.drawable.game1, "Contra")
        val g3 = GameModel(R.drawable.game2, "Hooked on Rose")
        val g4 = GameModel(R.drawable.game3, "Battle City")
        val g5 = GameModel(R.drawable.game4, "Play Station")
        val g6 = GameModel(R.drawable.game5, "Winning 11")
        val g7 = GameModel(R.drawable.game6, "Pro Evolution")

        gameList.add(g1)
        gameList.add(g2)
        gameList.add(g3)
        gameList.add(g4)
        gameList.add(g5)
        gameList.add(g6)
        gameList.add(g7)


        //3. Adapter
        val adapter = GameAdapter(gameList)
    }
}