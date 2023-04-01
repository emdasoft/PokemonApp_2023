package com.emdasoft.pokemonapp2023.presentation

import androidx.recyclerview.widget.DiffUtil
import com.emdasoft.pokemonapp2023.domain.entity.PokeName

class PokemonListDiffCallback(
    private val oldList: List<PokeName>,
    private val newList: List<PokeName>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = oldList[oldItemPosition]
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = oldList[oldItemPosition]
        return oldItem == newItem
    }
}