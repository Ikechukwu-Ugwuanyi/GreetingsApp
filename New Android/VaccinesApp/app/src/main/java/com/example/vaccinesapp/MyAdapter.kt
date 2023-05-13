package com.example.vaccinesapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val vaccineList: ArrayList<VaccineModel>)
    : RecyclerView.Adapter<>() {

        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            lateinit var vaccineImage: ImageView
            lateinit var vaccineTitle: TextView

            init {
                vaccineImage = itemView.findViewById(R.id.imageView)
                vaccineTitle = itemView.findViewById(R.id.text)
            }
        }




}