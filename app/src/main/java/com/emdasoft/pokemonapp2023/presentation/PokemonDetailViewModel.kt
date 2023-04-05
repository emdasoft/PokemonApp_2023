package com.emdasoft.pokemonapp2023.presentation

import android.app.Application
import androidx.lifecycle.*
import com.emdasoft.pokemonapp2023.data.RepositoryImpl
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo
import com.emdasoft.pokemonapp2023.domain.usecases.GetPokemonDetailsUseCase
import kotlinx.coroutines.launch

class PokemonDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val getPokemonDetailsUseCase = GetPokemonDetailsUseCase(repository)

    private val _pokemon = MutableLiveData<PokeInfo>()
    val pokemon: LiveData<PokeInfo>
        get() = _pokemon

    private val _shouldShowProgress = MutableLiveData<Boolean>()
    val shouldShowProgress: LiveData<Boolean>
        get() = _shouldShowProgress

    fun getPokemon(pokemonName: String) {
        _shouldShowProgress.value = true
        viewModelScope.launch {
            _pokemon.postValue(getPokemonDetailsUseCase.getPokemonDetails(pokemonName))
            _shouldShowProgress.value = false
        }
    }

}