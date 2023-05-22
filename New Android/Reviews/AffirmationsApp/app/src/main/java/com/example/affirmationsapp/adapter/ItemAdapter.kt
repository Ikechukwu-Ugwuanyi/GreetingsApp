package com.example.affirmationsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmationsapp.R
import com.example.affirmationsapp.model.Affirmation

/* class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //Create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}

 */

class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = view.findViewById(R.id.item_title)
        var imgView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}