package com.emdasoft.pokemonapp2023.presentation

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.emdasoft.pokemonapp2023.R
import com.emdasoft.pokemonapp2023.databinding.FragmentMainBinding

class MainFragment : Fragment(), PokemonListAdapter.SetOnItemClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding = null")

    private lateinit var rvAdapter: PokemonListAdapter

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addUpdateMenu()

        setupRecyclerView()

        viewModelObserve()

    }

    private fun addUpdateMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.update_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.update -> {
                        viewModel.getPokemonList()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun viewModelObserve() {
        viewModel.pokemonList.observe(viewLifecycleOwner) {
            rvAdapter.pokemonList = it
        }

        viewModel.shouldShowProgress.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

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

    override fun onItemClickListener(pokemonName: String) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, DetailFragment.newInstance(pokemonName))
            .addToBackStack(null)
            .commit()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
