package com.emdasoft.pokemonapp2023.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprite,
    val types: List<Types>
) : Parcelable

@Parcelize
data class Sprite(
    val frontDefault: String?,
) : Parcelable

@Parcelize
data class Types(
    val types: Type,
) : Parcelable

@Parcelize
data class Type(
    val name: String
) : Parcelable
