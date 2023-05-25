package com.example.notes.view_pager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentScreen2Binding

class Screen2Fragment : Fragment() {
    private lateinit var binding: FragmentScreen2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreen2Binding.inflate(inflater, container, false)

        binding.buttonSinginSc2.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_logInFragment)
        }
        binding.buttonRegisterSc2.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_registrationFragment)
        }
        return binding.root
    }
}