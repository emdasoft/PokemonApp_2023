package com.emdasoft.pokemonapp2023.data.network
import com.emdasoft.pokemonapp2023.data.retrofit.PokeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: PokeApiService by lazy {

        retrofit.create(PokeApiService::class.java)

    }

}