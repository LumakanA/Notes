package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.databinding.RegistrationBinding
import com.example.notes.extensions.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: RegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = binding.textInputName.text
        val email = binding.textInputEmail.text
        val enterpassword = binding.textInputEnterPassword.text
        val confirmpassword = binding.textInputConfirmPassword.text
        binding.textInputName.setOnClickListener {
            binding.textInputLayoutName.error = validateName(name)
        }
        binding.textInputEmail.setOnClickListener {
            binding.textInputLayoutEmail.error = validateEmail(email)
        }
        binding.textInputEnterPassword.setOnClickListener {
            binding.textInputLayoutEnterPassword.error = validateEnterPassword(enterpassword)
        }
        binding.textInputConfirmPassword.setOnClickListener {
            binding.textInputLayoutConfirmPassword.error = validateConfirmPassword(binding.textInputEnterPassword, binding.textInputConfirmPassword)
        }
    }
}