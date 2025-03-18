package com.adridoce.pokedex.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adridoce.pokedex.presentation.components.PokemonRecyclerView
import com.adridoce.pokedex.presentation.components.PokemonSearchBar
import com.adridoce.pokedex.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(modifier: Modifier, viewModel: HomeViewModel) {

    val pokemonList by viewModel.filteredPokemonList.observeAsState(emptyList())
    val query by viewModel.query.observeAsState("")
    val isLoading by viewModel.isLoading.observeAsState(false)


    Box(modifier = modifier.fillMaxSize()) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
        } else {
            Column {
                PokemonSearchBar(
                    query = query,
                    onQueryChange = { viewModel.searchPokemon(it) },
                    onSearch = { viewModel.searchPokemon(it) },
                    onActiveChange = { viewModel.onActiveChange(it) }
                )
                PokemonRecyclerView(pokemonList)
            }
        }
    }
}




