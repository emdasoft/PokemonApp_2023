package com.emdasoft.pokemonapp2023.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.emdasoft.pokemonapp2023.R
import com.emdasoft.pokemonapp2023.databinding.FragmentDetailBinding
import com.google.android.material.chip.Chip

class DetailFragment : Fragment() {

    private var pokemonId = UNDEFINED_ID

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

        viewModel.getPokemon(pokemonId)

        bindViews()

        setOnBackPressedListener()

    }

    private fun bindViews() {
        viewModel.pokemon.observe(viewLifecycleOwner) {
            binding.nameTextView.text = it.name
            binding.heightText.text =
                String.format(resources.getString(R.string.height), it.height * CORRECTION_INDEX)
            binding.weightText.text =
                String.format(resources.getString(R.string.weight), it.weight / CORRECTION_INDEX)
//            it.types.forEach {
//                val chip = Chip(binding.chipGroup.context)
//                chip.text = it
//                chip.isClickable = false
//                chip.isCheckable = false
//                binding.chipGroup.addView(chip)
//            }

            try {
                Glide.with(this).load(it.sprite).into(binding.imageView)
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
        if (!requireArguments().containsKey(POKEMON_ID)) {
            throw RuntimeException("Pokemon ID is absent")
        }
        pokemonId = requireArguments().getInt(POKEMON_ID)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val POKEMON_ID = "pokemon_id"
        private const val UNDEFINED_ID = -1
        private const val CORRECTION_INDEX = 10.0

        @JvmStatic
        fun newInstance(pokemonId: Int): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(POKEMON_ID, pokemonId)
                }
            }
        }
    }

}