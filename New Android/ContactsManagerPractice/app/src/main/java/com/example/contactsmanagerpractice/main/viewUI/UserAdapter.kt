package com.example.contactsmanagerpractice.main.viewUI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsmanagerpractice.main.model.User
import com.example.contactsmanagerpractice.R
import com.example.contactsmanagerpractice.databinding.CardItemBinding

class UserAdapter(private var userList: List<User>, private val clickListener: (User) -> Unit) :
RecyclerView.Adapter<UserAdapter.MyViewHolder>(){

    class MyViewHolder(private val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, clickListener: (User) -> Unit) {
            binding.nameTxt.text = user.name
            binding.emailTxt.text = user.email
           clickListener(user)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val binding: CardItemBinding =
            DataBindingUtil.inflate(layout, R.layout.card_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position], clickListener)
    }


}