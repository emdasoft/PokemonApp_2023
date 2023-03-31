package com.emdasoft.pokemonapp2023.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emdasoft.pokemonapp2023.data.RepositoryImpl
import com.emdasoft.pokemonapp2023.domain.models.PokeResult
import com.emdasoft.pokemonapp2023.domain.usecases.GetPokemonListUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = RepositoryImpl
    private val getPokemonListUseCase = GetPokemonListUseCase(repository)


    private val _pokemonList = MutableLiveData<List<PokeResult>>()
    val pokemonList: LiveData<List<PokeResult>>
        get() = _pokemonList


    fun getPokemonList() {
        viewModelScope.launch {
            _pokemonList.postValue(getPokemonListUseCase.getPokemonList())
        }
    }


}