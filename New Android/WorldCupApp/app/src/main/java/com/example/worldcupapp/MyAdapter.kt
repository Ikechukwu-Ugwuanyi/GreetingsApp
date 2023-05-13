package com.example.worldcupapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(private var activity: Activity, private var items: ArrayList<CountryModal>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): CountryModal {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, convertView: View?, p2: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if(convertView == null) {

        }
    }

    private class ViewHolder(view : View?) {
        val txtName: TextView? = null
        val txtCupWin: TextView? = null
        val flagImg: ImageView? = null
    }
}