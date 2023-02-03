package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.databinding.ActivityLoginBinding
import com.example.notes.extensions.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = binding.textInputEmail.text
        val enterpassword = binding.textInputEmail.text
        binding.textInputEmail.setOnClickListener {
            binding.textInputLayoutEmail.error = validateEmail(email)
        }
        binding.textInputPassword.setOnClickListener {
            binding.textInputLayoutPassword.error = validateEnterPassword(enterpassword)
        }
        binding.textView4.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
    }
}