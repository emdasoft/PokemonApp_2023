package com.emdasoft.pokemonapp2023.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emdasoft.pokemonapp2023.databinding.ListItemBinding
import com.emdasoft.pokemonapp2023.domain.entity.PokeName

class PokemonListAdapter(private val listener: SetOnItemClickListener) :
    RecyclerView.Adapter<PokemonViewHolder>() {

    var pokemonList = emptyList<PokeName>()
        set(value) {
            val callback = PokemonListDiffCallback(pokemonList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val binding = holder.binding
        val pokemonItem = pokemonList[position]
        with(binding) {
            tvPokemonName.text = pokemonItem.name
            tvPokemonId.text = String.format("#%s", position + INDEX_OFFSET)
            root.setOnClickListener {
                listener.onItemClickListener(pokemonItem.name)
            }
        }
    }

    interface SetOnItemClickListener {
        fun onItemClickListener(pokemonName: String)
    }

    companion object {
        private const val INDEX_OFFSET = 1
    }

}