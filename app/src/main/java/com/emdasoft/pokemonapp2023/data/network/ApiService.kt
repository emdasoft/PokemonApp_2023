package com.emdasoft.pokemonapp2023.data.network

import com.emdasoft.pokemonapp2023.data.network.model.PokeApiResponse
import com.emdasoft.pokemonapp2023.data.network.model.PokeInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = DEFAULT_LIMIT,
        @Query("offset") offset: Int = DEFAULT_OFFSET
    ): Response<PokeApiResponse>

    @GET("pokemon/{id}")
    suspend fun getPokemonInfo(@Path("id") id: Int): Response<PokeInfoDto>

    companion object {
        private const val DEFAULT_LIMIT = 1000
        private const val DEFAULT_OFFSET = 0
    }

}
