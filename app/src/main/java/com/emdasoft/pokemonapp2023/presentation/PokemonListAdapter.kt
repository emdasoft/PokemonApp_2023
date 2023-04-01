package com.emdasoft.pokemonapp2023.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emdasoft.pokemonapp2023.R
import com.emdasoft.pokemonapp2023.databinding.ListItemBinding
import com.emdasoft.pokemonapp2023.domain.entity.PokeResult

class PokemonListAdapter(private val listener: SetOnItemClickListener) :
    RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    var pokemonList = emptyList<PokeResult>()
        set(value) {
            val callback = PokemonListDiffCallback(pokemonList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ListItemBinding.bind(itemView)

        fun bindItem(
            pokeName: PokeResult,
            position: Int,
            listener: SetOnItemClickListener
        ) =
            with(binding) {
                tvPokemonName.text = pokeName.name
                tvPokemonId.text = String.format("#%s", position + INDEX_OFFSET)
                itemView.setOnClickListener {
                    listener.onItemClickListener(position)
                }
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
        holder.bindItem(pokemonList[position], position, listener)
    }

    interface SetOnItemClickListener {

        fun onItemClickListener(position: Int)
    }

    companion object {
        private const val INDEX_OFFSET = 1
    }

}