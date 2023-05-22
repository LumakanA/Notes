package com.example.notes.view_pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.BottomNavigationViewManager
import com.example.notes.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val adapter = PagerAdapter(this, 2)
        binding.viewPager2.adapter = adapter
        (activity as? BottomNavigationViewManager)?.setNavigationViewVisibility(false)
        return binding.root
    }
}