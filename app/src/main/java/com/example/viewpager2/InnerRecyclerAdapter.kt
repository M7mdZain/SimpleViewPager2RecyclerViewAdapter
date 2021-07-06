package com.example.viewpager2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.MainActivity.Companion.LOG_TAG
import java.util.*
/*
 * By: M7md.zain@gamil.com
 * 04.July.2021
 * */

class InnerRecyclerAdapter :
    RecyclerView.Adapter<InnerRecyclerAdapter.InnerViewHolder>() {

    // Tracking the currently loaded items in the RecyclerView
    private val currentLoadedPositions = ArrayList<Int>()

    private var days = 0
    fun setDays(days: Int) {
        this.days = days
    }

    class InnerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDay: TextView = view.findViewById(R.id.tv_day)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InnerViewHolder {
        val listItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_row_inner, parent, false)
        return InnerViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        holder.tvDay.text = (position + 1).toString()
        currentLoadedPositions.add(position)
        Log.d(LOG_TAG, "onViewRecycled: INNER $currentLoadedPositions")
    }

    override fun onViewRecycled(holder: InnerViewHolder) {
        super.onViewRecycled(holder)
        currentLoadedPositions.remove(Integer.valueOf(holder.adapterPosition))
        Log.d(LOG_TAG, "onViewRecycled: INNER $currentLoadedPositions")
    }

    override fun getItemCount() = days

}