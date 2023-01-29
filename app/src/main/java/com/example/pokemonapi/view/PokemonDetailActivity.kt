package com.example.pokemonapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokemonapi.R
import com.example.pokemonapi.commons.StringFormatter
import com.example.pokemonapi.databinding.ActivityPokemonDetailBinding
import com.example.pokemonapi.viewModel.PokemonViewModel

class PokemonDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonDetailBinding
    private lateinit var viewModel: PokemonViewModel
    private var pokemonId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        //ActionBar
        var actionBar = supportActionBar

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

    private fun getPokemonDetailById(){
        pokemonId = intent.extras?.getInt("pokemonId") ?: 0
        viewModel.getPokemonDetail(pokemonId)

    }

    private fun observe() {
        viewModel.pokemonDetailLiveData.observe(this) {

            when (it.types[0].type.name.toString()) {
                "grass" -> {
                    binding.wave.background.setTint(getColor(R.color.grass))
                    binding.type1.background.setTint(getColor(R.color.grass))
                }
                "fire" -> {
                    binding.wave.background.setTint(getColor(R.color.fire))
                    binding.type1.background.setTint(getColor(R.color.fire))
                }
                "bug" -> {
                    binding.wave.background.setTint(getColor(R.color.bug))
                    binding.type1.background.setTint(getColor(R.color.bug))
                }
                "water" -> {
                    binding.wave.background.setTint(getColor(R.color.water))
                    binding.type1.background.setTint(getColor(R.color.water))
                }
                "normal" -> {
                    binding.wave.background.setTint(getColor(R.color.normal))
                    binding.type1.background.setTint(getColor(R.color.normal))
                }
                "poison" -> {
                    binding.wave.background.setTint(getColor(R.color.poison))
                    binding.type1.background.setTint(getColor(R.color.poison))
                }
                "eletric" -> {
                    binding.wave.background.setTint(getColor(R.color.eletric))
                    binding.type1.background.setTint(getColor(R.color.eletric))
                }
                "flying" -> {
                    binding.wave.background.setTint(getColor(R.color.flying))
                    binding.type1.background.setTint(getColor(R.color.flying))
                }
                else -> {
                    binding.wave.background.setTint(getColor(R.color.other))
                    binding.type1.background.setTint(getColor(R.color.other))
                }
            }

            binding.type1.text = it.types[0].type.name.toString()

            if (it.types.count() > 1) {
                binding.type2.visibility = View.VISIBLE
                binding.type2.text = it.types[1].type.name.toString()

                when (it.types[1].type.name.toString()) {
                    "grass" -> binding.type2.background.setTint(getColor(R.color.grass))
                    "fire" -> binding.type2.background.setTint(getColor(R.color.fire))
                    "bug" -> binding.type2.background.setTint(getColor(R.color.bug))
                    "water" -> binding.type2.background.setTint(getColor(R.color.water))
                    "normal" -> binding.type2.background.setTint(getColor(R.color.normal))
                    "poison" -> binding.type2.background.setTint(getColor(R.color.poison))
                    "eletric" -> binding.type2.background.setTint(getColor(R.color.eletric))
                    "flying" -> binding.type2.background.setTint(getColor(R.color.flying))
                    else -> binding.type2.background.setTint(getColor(R.color.other))
                }
            }

            binding.number.text = StringFormatter().formatIDToThreeDigitsAndHash(pokemonId.toString())

            binding.name.text = StringFormatter().formatFirstLetterToUpperCase(it.name)

            Glide.with(this)
                .load(it.sprites.other.officialArtwork.frontDefault)
                .into(binding.profilePicture)

            binding.heightValue.text = "${(it.height / 10.0)}m"

            binding.weightValue.text = "${(it.weight / 10.0)}Kg"

        }
    }


}