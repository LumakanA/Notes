package com.example.notes.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.notes.MainActivity
import com.example.notes.R
import com.example.notes.databinding.FragmentRegistrationBinding
import com.example.notes.extensions.validateConfirmPassword
import com.example.notes.extensions.validateEmail
import com.example.notes.extensions.validateEnterPassword
import com.example.notes.extensions.validateName

const val PREF_NAME = "PREF_NAME"

class RegistrationFragment : Fragment() {
private lateinit var binding: FragmentRegistrationBinding
private lateinit var preferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        binding.buttonRegister.setOnClickListener {
            val nameError = validateName(binding.textInputName.text)
            val emailError = validateEmail(binding.textInputEmail.text)
            val enterPasswordError = validateEnterPassword(binding.textInputEnterPassword.text)
            val confirmPasswordError = validateConfirmPassword(
                binding.textInputEnterPassword,
                binding.textInputConfirmPassword
            )
            binding.textInputLayoutName.error = nameError
            binding.textInputLayoutEmail.error = emailError
            binding.textInputLayoutEnterPassword.error = enterPasswordError
            binding.textInputLayoutConfirmPassword.error = confirmPasswordError
            if (nameError == null && emailError == null && enterPasswordError == null && confirmPasswordError == null) {
                Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.action_registrationFragment_to_main_nav_graph)
                Log.d("nav", "логин - майн граф")
                val name = binding.textInputName.text.toString()
                preferences = requireContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
                preferences.edit()
                .putString(PREF_NAME, name)
                .apply()

                val intent = Intent(requireContext(), MainActivity::class.java)
                intent.putExtra("source", "registration")
                startActivity(intent)
            }
        }
        binding.textView3.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_logInFragment)
            Log.d("nav", "регистр - майн граф")
        }
        return binding.root
    }
}