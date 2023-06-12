package com.example.contactsmanagerapp.viewUI

import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsmanagerapp.databinding.CardItemBinding
import com.example.contactsmanagerapp.room.User

class MyRecyclerViewAdapter(private val userList:List<User>,
                            private val clickListener: (User) -> Unit)
    : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User, clickListener: (User) -> Unit) {
            binding.nameTextView.text = user.name
            binding.emailTextView.text = user.email

            binding.listItemLayout.setOnClickListener{
                clickListener(user)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}