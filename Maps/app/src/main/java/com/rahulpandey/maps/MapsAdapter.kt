package com.rahulpandey.maps

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "MapsAdapter-Truong"

class MapsAdapter(val maps: List<UserMap>, val listener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {
    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = maps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = holder.itemView.findViewById<TextView>(android.R.id.text1)
        item.text = maps[position].title
        holder.itemView.setOnClickListener {
            Log.d(TAG, "onBindViewHolder at $position")
            listener.onItemClick(position)
        }
    }
}
