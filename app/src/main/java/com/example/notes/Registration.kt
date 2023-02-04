package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        binding.buttonRegister.setOnClickListener {
            if (validateName(name) == null
                && validateEmail(email) == null
                && validateEnterPassword(enterpassword) == null
                && validateConfirmPassword(binding.textInputEnterPassword, binding.textInputConfirmPassword) == null
            ) {
                binding.textInputLayoutName.error = null
                binding.textInputLayoutEmail.error = null
                binding.textInputLayoutEnterPassword.error = null
                binding.textInputLayoutConfirmPassword.error = null
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
            } else {
                binding.textInputLayoutName.error = validateName(name)
                binding.textInputLayoutEmail.error = validateEmail(email)
                binding.textInputLayoutEnterPassword.error = validateEnterPassword(enterpassword)
                binding.textInputLayoutConfirmPassword.error = validateConfirmPassword(binding.textInputEnterPassword, binding.textInputConfirmPassword)
            }
        }
        binding.textView3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}