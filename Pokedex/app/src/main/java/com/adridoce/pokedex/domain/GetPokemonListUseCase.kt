package com.adridoce.pokedex.domain

import com.adridoce.pokedex.data.HomeRepository
import com.adridoce.pokedex.data.local.models.Pokemon
import com.adridoce.pokedex.data.network.response.PokemonResponse

class GetPokemonListUseCase {
    private val repository = HomeRepository()

    suspend operator fun invoke(): List<PokemonResponse> {
        val pokemonList = repository.getPokemonList()

        return pokemonList.map {
            repository.getPokemon(it.name)
        }
    }
}