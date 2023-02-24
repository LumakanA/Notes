package com.example.notes


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notes.databinding.ActivityRegistrationBinding
import com.example.notes.extensions.validateConfirmPassword
import com.example.notes.extensions.validateEmail
import com.example.notes.extensions.validateEnterPassword
import com.example.notes.extensions.validateName

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()

                val name = binding.textInputName.text.toString()
                val sharedPreferences1 = getSharedPreferences("Registration", Context.MODE_PRIVATE)
                val editor = sharedPreferences1.edit()
                editor.putString("name", name)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("source", "registration")
                startActivity(intent)
            }
        }
        binding.textView3.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
    }
}