package com.emdasoft.pokemonapp2023.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emdasoft.pokemonapp2023.data.RepositoryImpl
import com.emdasoft.pokemonapp2023.domain.entity.Pokemon
import com.emdasoft.pokemonapp2023.domain.usecases.GetPokemonDetailsUseCase
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {

    private val repository = RepositoryImpl

    private val getPokemonDetailsUseCase = GetPokemonDetailsUseCase(repository)

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon>
        get() = _pokemon

    fun getPokemon(pokemonId: Int) {
        viewModelScope.launch {
            _pokemon.postValue(getPokemonDetailsUseCase.getPokemonDetails(pokemonId))
        }
    }

}