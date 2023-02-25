package com.example.pokemonapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapi.R
import com.example.pokemonapi.databinding.ActivityMainBinding
import com.example.pokemonapi.view.adapter.PokemonAdapter
import com.example.pokemonapi.viewModel.PokemonDetailViewModel
import com.example.pokemonapi.viewModel.PokemonViewModel

class PokemonActivity : AppCompatActivity() {

    private lateinit var viewModel: PokemonViewModel
//    private lateinit var viewModelPokemonDetail: PokemonDetailViewModel
    private lateinit var binding: ActivityMainBinding
    private val adapter = PokemonAdapter(::onPokemonItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        //LayoutManager
        binding.recyclerPokemon.layoutManager = GridLayoutManager(this,2)
        //Adapter
        binding.recyclerPokemon.adapter = adapter

        viewModel.getPokemonList()

        observe()
    }

    private fun observe() {
        viewModel.listPokemonsLiveData.observe(this)
        {
            adapter.updateList(it)
            binding.progressBar.visibility = View.GONE
        }

    }

    private fun onPokemonItemClick(id: Int) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra("pokemonId", id)
        startActivity(intent)
    }

}