package com.emdasoft.pokemonapp2023.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.emdasoft.pokemonapp2023.R
import com.emdasoft.pokemonapp2023.databinding.FragmentDetailBinding
import com.google.android.material.chip.Chip

class DetailFragment : Fragment() {

    private var pokemonName = UNDEFINED_NAME

    private val viewModel by lazy {
        ViewModelProvider(this)[PokemonDetailViewModel::class.java]
    }

    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPokemon(pokemonName)

        showProgress()

        setOnBackPressedListener()

        bindViews()

    }

    private fun showProgress() {
        viewModel.shouldShowProgress.observe(viewLifecycleOwner) {
            with(binding) {
                progressDetail.isVisible = it
                detailsCard.isVisible = !it
                backButton.isVisible = !it
            }
        }
    }

    private fun bindViews() {
        viewModel.pokemon.observe(viewLifecycleOwner) { pokeInfo ->
            with(binding) {
                nameTextView.text = pokeInfo.name
                heightText.text =
                    String.format(
                        resources.getString(R.string.height),
                        pokeInfo.height * CORRECTION_INDEX
                    )
                weightText.text =
                    String.format(
                        resources.getString(R.string.weight),
                        pokeInfo.weight / CORRECTION_INDEX
                    )
                pokeInfo.types.forEach {
                    val chip = Chip(binding.chipGroup.context)
                    chip.text = it
                    chip.isClickable = false
                    chip.isCheckable = false
                    chipGroup.addView(chip)
                }
            }
            try {
                Glide.with(this).load(pokeInfo.sprite).into(binding.imageView)
            } catch (e: Exception) {
                binding.imageView.setImageResource(R.drawable.tv_ball)
            }

        }
    }

    private fun setOnBackPressedListener() {
        binding.backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun parseArgs() {
        if (!requireArguments().containsKey(POKEMON_NAME)) {
            throw RuntimeException("Pokemon ID is absent")
        }
        pokemonName = requireArguments().getString(POKEMON_NAME).toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val POKEMON_NAME = "pokemon_name"
        private const val UNDEFINED_NAME = ""
        private const val CORRECTION_INDEX = 10.0

        @JvmStatic
        fun newInstance(pokemonName: String): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(POKEMON_NAME, pokemonName)
                }
            }
        }
    }

}