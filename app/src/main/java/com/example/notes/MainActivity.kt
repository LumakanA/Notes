package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes.databinding.ActivityLoginBinding
import com.example.notes.extensions.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = binding.textInputEmail.text
        val enterpassword = binding.textInputPassword.text
        fun setError(
            emailError: String?,
            passwordError: String?
        ) {
            binding.textInputLayoutEmail.error = emailError
            binding.textInputLayoutPassword.error = passwordError
        }
        binding.buttonSingin.setOnClickListener {
            val emailError = validateEmail(email)
            val passwordError = validateEnterPassword(enterpassword)

            if (emailError == null && passwordError == null) {
                setError(null, null)
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
            } else {
                setError(emailError, passwordError)
            }
        }
        binding.textView4.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
    }
}