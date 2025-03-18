package com.adridoce.pokedex.data

import com.adridoce.pokedex.data.local.models.Pokemon
import com.adridoce.pokedex.data.network.HomeService
import com.adridoce.pokedex.data.network.response.PokemonResponse

class HomeRepository {
    val api = HomeService()

    suspend fun getPokemonList(): List<Pokemon> {
        return api.getPokemonList()
    }

    suspend fun getPokemon(name: String): PokemonResponse{
        return api.getPokemon(name)
    }
}