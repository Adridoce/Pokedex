package com.adridoce.pokedex.data.network.response

import com.adridoce.pokedex.data.local.models.Sprite
import com.adridoce.pokedex.data.local.models.TypeSlot
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("types") val types: List<TypeSlot>,
    @SerializedName("sprites") val image: Sprite
)
