package com.example.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences1 =
            requireActivity().getSharedPreferences("Registration", Context.MODE_PRIVATE)
        val sharedPreferences2 =
            requireActivity().getSharedPreferences("LogIn", Context.MODE_PRIVATE)

        val source = requireActivity().intent.getStringExtra("source")
        if (source == "registration") {
            val name = sharedPreferences1.getString("name", "")
            val welcomeMessage = getString(R.string.welcome_name, name)
            binding.textViewWelcomeTextView.text = welcomeMessage
        } else if (source == "login") {
            val email = sharedPreferences2.getString("email", "")
            val welcomeMessage = getString(R.string.welcome_email, email)
            binding.textViewWelcomeTextView.text = welcomeMessage
        }

        binding.imageViewExit.setOnClickListener {
            val intent = Intent(requireContext(), LogInActivity::class.java)
            startActivity(intent)
        }
    }
}