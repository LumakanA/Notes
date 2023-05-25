package com.example.notes.view_pager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.BottomNavigationViewManager
import com.example.notes.databinding.FragmentScreen1Binding

class Screen1Fragment : Fragment() {
    private lateinit var binding: FragmentScreen1Binding
    private var bottomNavigationViewManager: BottomNavigationViewManager? = null
    override fun onAttach(context: Context) {
        if (context is BottomNavigationViewManager) {
            bottomNavigationViewManager = context
        }
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreen1Binding.inflate(inflater, container, false)
        return binding.root
    }
}