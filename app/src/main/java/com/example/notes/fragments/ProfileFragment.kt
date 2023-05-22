package com.example.notes.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.BottomNavigationViewManager
import com.example.notes.R
import com.example.notes.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences =
            requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        val source = sharedPreferences.getString("source", "")

        if (source == "registration") {
            val name = sharedPreferences.getString(PREF_NAME, "")
            val welcomeMessage = getString(R.string.welcome_name, name)
            binding.textViewWelcomeTextView.text = welcomeMessage
        } else if (source == "login") {
            val email = sharedPreferences.getString(PREF_EMAIL, "")
            val welcomeMessage = getString(R.string.welcome_email, email)
            binding.textViewWelcomeTextView.text = welcomeMessage
        }

        binding.imageViewExit.setOnClickListener {
            findNavController().navigate(R.id.logInFragment)
        }
        (activity as? BottomNavigationViewManager)?.setNavigationViewVisibility(true)
    }
}
