package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes.databinding.ActivityLoginBinding
import com.example.notes.extensions.*

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSingin.setOnClickListener {
            val emailError = validateEmail(binding.textInputEmail.text)
            val passwordError = validateEnterPassword(binding.textInputPassword.text)
            binding.textInputLayoutEmail.error = emailError
            binding.textInputLayoutPassword.error = passwordError
            if (emailError == null && passwordError == null) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
            }
        }
        binding.textView4.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}