package com.emdasoft.pokemonapp2023.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emdasoft.pokemonapp2023.data.RepositoryImpl
import com.emdasoft.pokemonapp2023.domain.models.PokeName
import com.emdasoft.pokemonapp2023.domain.usecases.GetPokemonListUseCase

class MainViewModel : ViewModel() {

    private val repository = RepositoryImpl
    private val getPokemonListUseCase = GetPokemonListUseCase(repository)

    private val _pokemonList = MutableLiveData<List<PokeName>>()
    val pokemonList: LiveData<List<PokeName>>
        get() = _pokemonList

    fun getPokemonList() {
        _pokemonList.value = getPokemonListUseCase()
    }

}