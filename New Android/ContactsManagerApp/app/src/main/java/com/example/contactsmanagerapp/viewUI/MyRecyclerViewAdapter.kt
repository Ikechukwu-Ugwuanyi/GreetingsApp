package com.example.contactsmanagerapp.viewUI

import androidx.recyclerview.widget.RecyclerView
import com.example.contactsmanagerapp.databinding.CardItemBinding
import com.example.contactsmanagerapp.generated.callback.OnClickListener
import com.example.contactsmanagerapp.room.User

class MyRecyclerViewAdapter(private val userList: List<User>, private val clickListener: (User) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {

}

class MyViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(user: User, clickListener: (User) -> Unit) {
        binding.textView.text = user.name
        binding.textView2.text = user.email

        binding.listItemLayout.setOnClickListener{
            clickListener(user)
        }
    }
}