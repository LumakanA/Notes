package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.databinding.ActivityRegistrationBinding
import com.example.notes.extensions.validateConfirmPassword
import com.example.notes.extensions.validateEmail
import com.example.notes.extensions.validateEnterPassword
import com.example.notes.extensions.validateName

class Registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
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
        binding.textView3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}