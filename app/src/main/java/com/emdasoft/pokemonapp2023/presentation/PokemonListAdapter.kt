package com.emdasoft.pokemonapp2023.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emdasoft.pokemonapp2023.R
import com.emdasoft.pokemonapp2023.databinding.ListItemBinding
import com.emdasoft.pokemonapp2023.domain.models.PokeName

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    var pokemonList = emptyList<PokeName>()
        set(value) {
            val callback = PokemonListDiffCallback(pokemonList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ListItemBinding.bind(itemView)

        fun bindItem(pokeName: PokeName, position: Int) = with(binding) {
            tvPokemonName.text = pokeName.name
            tvPokemonId.text = String.format("#%s", position + 1)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent,
            false
        )
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindItem(pokemonList[position], position)
    }
}