package com.adridoce.pokedex.data.network.clients

import com.adridoce.pokedex.data.network.response.HomeResponse
import com.adridoce.pokedex.data.network.response.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface HomeClient {
    @GET("pokemon?limit=151/")
    suspend fun getPokemonList(): Response<HomeResponse>

    @GET("pokemon/{name}/")
    suspend fun getPokemon(@Path("name") name: String): Response<PokemonResponse>
}

// https://pokeapi.co/api/v2/pokemon/1/
// https://pokeapi.co/api/v2/pokemon?limit=151