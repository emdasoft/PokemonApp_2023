package com.emdasoft.pokemonapp2023.presentation

import android.app.Application
import androidx.lifecycle.*
import com.emdasoft.pokemonapp2023.data.RepositoryImpl
import com.emdasoft.pokemonapp2023.domain.entity.PokeName
import com.emdasoft.pokemonapp2023.domain.usecases.GetPokemonListUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)
    private val getPokemonListUseCase = GetPokemonListUseCase(repository)

    private val _pokemonList = MutableLiveData<List<PokeName>>()
    val pokemonList: LiveData<List<PokeName>>
        get() = _pokemonList

    private val _shouldShowProgress = MutableLiveData<Boolean>()
    val shouldShowProgress: LiveData<Boolean>
        get() = _shouldShowProgress

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        _shouldShowProgress.value = true
        viewModelScope.launch {
            _pokemonList.postValue(getPokemonListUseCase.getPokemonList())
            _shouldShowProgress.value = false
        }

    }

}