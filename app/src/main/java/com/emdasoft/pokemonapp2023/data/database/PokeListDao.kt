package com.emdasoft.pokemonapp2023.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokeListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPokemonName(pokeNameDbModel: PokeNameDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPokemonInfo(pokeInfoDbModel: PokeInfoDbModel)

    @Query("SELECT * FROM pokemon_info WHERE name=:name LIMIT 1")
    suspend fun getPokemonInfo(name: String): PokeInfoDbModel

    @Query("SELECT * FROM pokemon_info")
    suspend fun getPokemonListByName(): List<PokeInfoDbModel>

}