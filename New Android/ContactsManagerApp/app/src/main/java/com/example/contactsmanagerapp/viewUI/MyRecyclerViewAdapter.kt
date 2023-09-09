package com.example.contactsmanagerapp.viewUI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsmanagerapp.R
import com.example.contactsmanagerapp.databinding.CardItemBinding
import com.example.contactsmanagerapp.room.User


class MyRecyclerViewAdapter(private val userList: List<User>, private val clickListener: (User) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding :CardItemBinding = DataBindingUtil.
                inflate(layoutInflater, R.layout.card_item, parent,false )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position], clickListener)
    }

}

class MyViewHolder(private val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(user: User, clickListener: (User) -> Unit) {
        binding.textView.text = user.name
        binding.textView2.text = user.email

        binding.listItemLayout.setOnClickListener{
            clickListener(user)
        }
    }
}