package com.example.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import java.util.*

/*
 * By: M7md.zain@gamil.com
 * 04.July.2021
 * */

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "LOG_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNestedViewPagerRecyclerView()
    }

    private fun setupNestedViewPagerRecyclerView() {
        val viewPager2 = findViewById<ViewPager2>(R.id.pager)
        viewPager2.adapter = OuterRecyclerAdapter(createMonths())
        viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL
    }

    private fun createMonths(): List<Month> {
        val months: MutableList<Month> = ArrayList<Month>()
        months.add(Month("January", 31))
        months.add(Month("February", 28))
        months.add(Month("March", 31))
        months.add(Month("April", 30))
        months.add(Month("May", 31))
        months.add(Month("June", 30))
        months.add(Month("July", 31))
        months.add(Month("August", 31))
        months.add(Month("September", 30))
        months.add(Month("October", 31))
        months.add(Month("November", 30))
        months.add(Month("December", 31))
        return months
    }

}