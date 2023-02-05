package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes.databinding.ActivityLoginBinding
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
        fun setError(
            nameError: String?,
            emailError: String?,
            enterPasswordError: String?,
            confirmPasswordError: String?
        ) {
            binding.textInputLayoutName.error = nameError
            binding.textInputLayoutEmail.error = emailError
            binding.textInputLayoutEnterPassword.error = enterPasswordError
            binding.textInputLayoutConfirmPassword.error = confirmPasswordError
        }
        binding.buttonRegister.setOnClickListener {
            val nameError = validateName(name)
            val emailError = validateEmail(email)
            val enterPasswordError = validateEnterPassword(enterpassword)
            val confirmPasswordError = validateConfirmPassword(
                binding.textInputEnterPassword,
                binding.textInputConfirmPassword
            )
            if (nameError == null && emailError == null && enterPasswordError == null && confirmPasswordError == null) {
                setError(null, null, null, null)
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
            } else {
                setError(nameError, emailError, enterPasswordError, confirmPasswordError)
            }
        }
        binding.textView3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}