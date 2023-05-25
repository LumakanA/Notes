package com.example.notes.view_pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(
    val fragment: Fragment,
    private val count: Int
) : FragmentStateAdapter(fragment) {
    private val fragmentList = listOf<Fragment>(
        Screen1Fragment(),
        Screen2Fragment()
    )
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}