package com.example.pokemonapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokemonapi.R
import com.example.pokemonapi.commons.StringFormatter
import com.example.pokemonapi.databinding.ActivityPokemonDetailBinding
import com.example.pokemonapi.databinding.PokemonTypeBinding
import com.example.pokemonapi.viewModel.PokemonDetailViewModel

class PokemonDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonDetailBinding
    private lateinit var pokemonDetailViewModel: PokemonDetailViewModel
    private var pokemonId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonDetailViewModel = ViewModelProvider(this).get(PokemonDetailViewModel::class.java)

        //ActionBar
        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        getPokemonDetailById()

        observe()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getPokemonDetailById() {
        pokemonId = intent.extras?.getInt("pokemonId") ?: 0
        pokemonDetailViewModel.getPokemonDetail(pokemonId)
    }

    private fun observe() {
        pokemonDetailViewModel.pokemonDetailLiveData.observe(this) {
            when (it.types[0].type.name) {
                "grass" -> binding.wave.background.setTint(getColor(R.color.grass))
                "fire" -> binding.wave.background.setTint(getColor(R.color.fire))
                "bug" -> binding.wave.background.setTint(getColor(R.color.bug))
                "water" -> binding.wave.background.setTint(getColor(R.color.water))
                "normal" -> binding.wave.background.setTint(getColor(R.color.normal))
                "poison" -> binding.wave.background.setTint(getColor(R.color.poison))
                "eletric" -> binding.wave.background.setTint(getColor(R.color.eletric))
                "flying" -> binding.wave.background.setTint(getColor(R.color.flying))
                else -> binding.wave.background.setTint(getColor(R.color.other))
            }

            it.types.map { type ->
                val typeBinding = PokemonTypeBinding.inflate(LayoutInflater.from(this))
                typeBinding.pokemonType.text = StringFormatter().formatFirstLetterToUpperCase(type.type.name)

                binding.layoutTypes.addView(typeBinding.root)

                when (type.type.name) {
                    "grass" -> typeBinding.pokemonType.background.setTint(getColor(R.color.grass))
                    "fire" -> typeBinding.pokemonType.background.setTint(getColor(R.color.fire))
                    "bug" -> typeBinding.pokemonType.background.setTint(getColor(R.color.bug))
                    "water" -> typeBinding.pokemonType.background.setTint(getColor(R.color.water))
                    "normal" -> typeBinding.pokemonType.background.setTint(getColor(R.color.normal))
                    "poison" -> typeBinding.pokemonType.background.setTint(getColor(R.color.poison))
                    "eletric" -> typeBinding.pokemonType.background.setTint(getColor(R.color.eletric))
                    "flying" -> typeBinding.pokemonType.background.setTint(getColor(R.color.flying))
                    else -> typeBinding.pokemonType.background.setTint(getColor(R.color.other))
                }
            }

            binding.number.text =
                StringFormatter().formatIDToThreeDigitsAndHash(pokemonId.toString())

            binding.name.text = StringFormatter().formatFirstLetterToUpperCase(it.name)

            Glide.with(this)
                .load(it.sprites.other.officialArtwork.frontDefault)
                .into(binding.profilePicture)

            binding.heightValue.text = "${(it.height / 10.0)}m"

            binding.weightValue.text = "${(it.weight / 10.0)}Kg"

        }

        pokemonDetailViewModel.errorCheckLiveData.observe(this) {

            binding.pokemonDetailPage.visibility = View.INVISIBLE
            binding.errorLayout.visibility = View.VISIBLE

            if (it) {
                binding.pokemonDetailPage.visibility = View.VISIBLE
                binding.errorLayout.visibility = View.INVISIBLE
            }

            binding.progressBar.visibility = View.GONE
        }
    }
}