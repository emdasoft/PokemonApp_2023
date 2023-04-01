package com.emdasoft.pokemonapp2023.data.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface PokeListDao {

    @Query("SELECT name FROM pokemon_info")
    fun getPokemonList() : List<PokeInfoDbModel>

    @Query("SELECT * FROM pokemon_info WHERE id=:id LIMIT 1")
    fun getPokemonInfo(id: Int) : PokeInfoDbModel

}