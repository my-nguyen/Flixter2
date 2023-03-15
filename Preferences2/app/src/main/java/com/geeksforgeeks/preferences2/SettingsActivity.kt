package com.geeksforgeeks.preferences2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geeksforgeeks.preferences2.databinding.ActivitySettingsBinding

class SettingsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Settings"
        supportFragmentManager.beginTransaction().replace(R.id.frame, SettingsFragment()).commit()
    }
}