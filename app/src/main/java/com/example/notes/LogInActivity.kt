package com.example.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notes.databinding.ActivityLoginBinding
import com.example.notes.extensions.validateEmail
import com.example.notes.extensions.validateEnterPassword

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

                val email = binding.textInputEmail.text.toString()
                val sharedPreferences = getSharedPreferences("LogIn", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("email", email)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("source", "login")
                startActivity(intent)
            }
        }
        binding.textView4.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}