package com.adridoce.pokedex.data.network

import com.adridoce.pokedex.data.local.models.Pokemon
import com.adridoce.pokedex.data.network.clients.HomeClient
import com.adridoce.pokedex.data.network.response.PokemonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemonList(): List<Pokemon>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(HomeClient::class.java).getPokemonList()
            response.body()?.results ?: listOf()
        }
    }

    suspend fun getPokemon(name: String): PokemonResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(HomeClient::class.java).getPokemon(name)
            response.body()!!
        }
    }
}