package com.emdasoft.pokemonapp2023.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.emdasoft.pokemonapp2023.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var pokemonId = UNDEFINED_ID

    private lateinit var viewModel: PokemonDetailViewModel

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

        viewModel = ViewModelProvider(this)[PokemonDetailViewModel::class.java]

        viewModel.getPokemon(pokemonId)

        viewModel.pokemon.observe(viewLifecycleOwner) {
            binding.tvName.text = it.name
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