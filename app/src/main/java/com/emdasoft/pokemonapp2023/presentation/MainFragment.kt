package com.emdasoft.pokemonapp2023.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.emdasoft.pokemonapp2023.R
import com.emdasoft.pokemonapp2023.databinding.FragmentMainBinding

class MainFragment : Fragment(), PokemonListAdapter.SetOnItemClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding = null")

    private lateinit var rvAdapter: PokemonListAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getPokemonList()

        viewModel.pokemonList.observe(viewLifecycleOwner) {
            rvAdapter.pokemonList = it
        }

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        with(binding) {
            rvPokemonNames.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            rvAdapter = PokemonListAdapter(this@MainFragment)
            rvPokemonNames.adapter = rvAdapter
        }
    }

    override fun onItemClickListener(position: Int) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, DetailFragment.newInstance(
                position + INDEX_OFFSET))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val INDEX_OFFSET = 1
    }
}
