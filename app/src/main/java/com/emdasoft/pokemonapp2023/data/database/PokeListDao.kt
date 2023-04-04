package com.emdasoft.pokemonapp2023.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo

@Dao
interface PokeListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPokemonName(pokeNameDbModel: PokeNameDbModel)

    @Query("SELECT name FROM pokemon_name")
    suspend fun getPokemonList(): List<PokeNameDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPokemonInfo(pokeInfoDbModel: PokeInfoDbModel)

    @Query("SELECT * FROM pokemon_info WHERE id=:id LIMIT 1")
    suspend fun getPokemonInfo(id: Int): PokeInfoDbModel

}