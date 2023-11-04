package com.example.movieapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.data.model.Movie
import com.example.movieapp.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>(){

    private val movieList = ArrayList<Movie>()

    fun setList(movie: List<Movie>) {
        movieList.clear()
        movieList.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil
            .inflate(layoutInflater,
                R.layout.list_item,
                parent,
                false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.textview.text = movie.title
            binding.textOverview.text = movie.overview


        }
    }
}