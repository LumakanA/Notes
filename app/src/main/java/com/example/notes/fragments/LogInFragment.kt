package com.example.notes.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.BottomNavigationViewManager
import com.example.notes.R
import com.example.notes.databinding.FragmentLogInBinding
import com.example.notes.extensions.validateEmail
import com.example.notes.extensions.validateEnterPassword

const val APP_PREFERENCES = "APP_PREFERENCES"
const val PREF_EMAIL = "PREF_EMAIL"

class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding
    private lateinit var preferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        binding.buttonSingin.setOnClickListener {
            val emailError = validateEmail(binding.textInputEmail.text)
            val passwordError = validateEnterPassword(binding.textInputPassword.text)
            binding.textInputLayoutEmail.error = emailError
            binding.textInputLayoutPassword.error = passwordError
            if (emailError == null && passwordError == null) {
                Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_logInFragment_to_profile_nav_graph)
                val email = binding.textInputEmail.text.toString()
                preferences =
                    requireContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
                preferences.edit()
                    .putString(PREF_EMAIL, email)
                    .putString("source", "login")
                    .apply()
            }
        }
        binding.textView4.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_registrationFragment)
        }
        (activity as? BottomNavigationViewManager)?.setNavigationViewVisibility(false)
        return binding.root
    }

}