package com.emdasoft.pokemonapp2023.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emdasoft.pokemonapp2023.R
import com.emdasoft.pokemonapp2023.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}