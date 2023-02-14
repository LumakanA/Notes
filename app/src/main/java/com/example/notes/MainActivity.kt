package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.buttonNavigationViewMenu.setOnItemReselectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.tasks -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, TasksFragment())
                    true
                }
                R.id.profile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, ProfileFragment())
                    true
                }
                R.id.history -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, HistoryFragment())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}