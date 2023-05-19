package com.example.topgamesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(val gamesList: ArrayList<GameModel>) :
    RecyclerView.Adapter<GameAdapter.MyViewHolder>(){

        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var gameImg: ImageView
            var gameTitle: TextView

            init {
                gameImg = itemView.findViewById(R.id.cardViewImg)
                gameTitle = itemView.findViewById(R.id.cardViewTxt)

                itemView.setOnClickListener() {
                    Toast.makeText(itemView.context, "You Chose: ${gamesList[adapterPosition].cardTxt}",
                    Toast.LENGTH_SHORT).show()
                }
            }


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_layout, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.gameImg.setImageResource(gamesList[position].imgCard)
        holder.gameTitle.setText(gamesList[position].cardTxt)
    }
}