package com.emdasoft.pokemonapp2023.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("pokemon_name")
data class PokeNameDbModel(
    @PrimaryKey
    val name: String,
)