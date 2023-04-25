
package com.example.notes.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.BottomNavigationViewManager
import com.example.notes.R
import com.example.notes.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private var bottomNavigationViewManager: BottomNavigationViewManager? = null

    override fun onAttach(context: Context) {
        if (context is BottomNavigationViewManager) {
            bottomNavigationViewManager = context
        }
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        bottomNavigationViewManager?.setNavigationViewVisibility(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val sharedPreferences1 =
//            requireActivity().getSharedPreferences("Registration", Context.MODE_PRIVATE)
//        val sharedPreferences2 =
//            requireActivity().getSharedPreferences("LogIn", Context.MODE_PRIVATE)

//        val source = requireActivity().intent.getStringExtra("source")
//        if (source == "registration") {
//            val name = sharedPreferences1.getString(PREF_NAME, "")
//            val welcomeMessage = getString(R.string.welcome_name, name)
//            binding.textViewWelcomeTextView.text = welcomeMessage
//        } else if (source == "login") {
//            val email = sharedPreferences2.getString(PREF_EMAIL, "")
//            val welcomeMessage = getString(R.string.welcome_email, email)
//            binding.textViewWelcomeTextView.text = welcomeMessage
//        }TODO()
        binding.imageViewExit.setOnClickListener {
            findNavController().navigate(R.id.logInFragment)
            Log.d("nav", "профиль - логин")
        }
    }
}