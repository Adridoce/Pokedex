package com.adridoce.pokedex.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adridoce.pokedex.data.local.models.Pokemon
import com.adridoce.pokedex.data.network.response.PokemonResponse
import com.adridoce.pokedex.domain.GetPokemonListUseCase
import kotlinx.coroutines.launch
import okhttp3.internal.ignoreIoExceptions

class HomeViewModel : ViewModel() {

    val getPokemonListUseCase = GetPokemonListUseCase()

    private val _query = MutableLiveData<String>()
    val query: LiveData<String> get() = _query

    private val _isSearchBarActive = MutableLiveData(false)
    val isSearchBarActive: LiveData<Boolean> get() = _isSearchBarActive

    private val _pokemonList = MutableLiveData<List<PokemonResponse>>(emptyList())
    val pokemonList: LiveData<List<PokemonResponse>> get() = _pokemonList

    private val _filteredPokemonList = MutableLiveData<List<PokemonResponse>>(emptyList())
    val filteredPokemonList: LiveData<List<PokemonResponse>> get() = _filteredPokemonList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        fetchPokemonList()
    }

    fun onActiveChange(isActive: Boolean) {
        _isSearchBarActive.value = isActive
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            _isLoading.value = true
            val results = getPokemonListUseCase()
            _pokemonList.value = results
            _filteredPokemonList.value = results
            _isLoading.value = false
        }
    }

    fun searchPokemon(newQuery: String) {

        _query.value = newQuery

        val filteredList =
            _pokemonList.value?.filter { pokemon ->
                pokemon.name.contains(newQuery, ignoreCase = true) ||
                        pokemon.types.any { it.type.name.contains(newQuery, ignoreCase = true) }
            } ?: emptyList()

        _filteredPokemonList.value = filteredList
    }
}


