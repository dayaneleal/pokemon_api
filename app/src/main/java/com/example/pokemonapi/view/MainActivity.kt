package com.example.pokemonapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapi.databinding.ActivityMainBinding
import com.example.pokemonapi.view.adapter.PokemonAdapter
import com.example.pokemonapi.viewModel.PokemonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PokemonViewModel
    private lateinit var binding: ActivityMainBinding
    private val adapter = PokemonAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //LayoutManager
        binding.recyclerPokemon.layoutManager = LinearLayoutManager(this)
        //Adapter
        binding.recyclerPokemon.adapter = adapter

        viewModel.getPokemon()

        setContentView(binding.root)
    }
}