package com.example.viewpager2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.MainActivity.Companion.LOG_TAG
import java.util.*

/*
 * By: M7md.zain@gamil.com
 * 04.July.2021
 * */

class OuterRecyclerAdapter(months: List<Month>) :
    RecyclerView.Adapter<OuterRecyclerAdapter.OuterViewHolder>() {

    private val mMonths: List<Month> = months

    // Tracking the currently loaded items in the RecyclerView
    private val currentLoadedPositions = ArrayList<Int>()

    class OuterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvMonth: TextView? = view.findViewById(R.id.tv_month)
        var innerRecyclerAdapter: InnerRecyclerAdapter? = null

        init {
            // Setting up the inner RecyclerView
            innerRecyclerAdapter = InnerRecyclerAdapter()

            val innerRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_inner)
            innerRecyclerView.apply {
                layoutManager = LinearLayoutManager(view.context)
                hasFixedSize()
                adapter = innerRecyclerAdapter
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuterViewHolder {
        val listItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_row_outer, parent, false)
        return OuterViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: OuterViewHolder, position: Int) {
        val month = mMonths[position]
        holder.tvMonth?.text = month.name
        holder.innerRecyclerAdapter?.setDays(month.dayCount)
        currentLoadedPositions.add(position)
        Log.d(LOG_TAG, "onViewRecycled: OUTER: $currentLoadedPositions")
    }

    override fun getItemCount() = mMonths.size

    override fun onViewRecycled(holder: OuterViewHolder) {
        super.onViewRecycled(holder)
        currentLoadedPositions.remove(Integer.valueOf(holder.adapterPosition))
        Log.d(LOG_TAG, "onViewRecycled: OUTER: $currentLoadedPositions")
    }
}