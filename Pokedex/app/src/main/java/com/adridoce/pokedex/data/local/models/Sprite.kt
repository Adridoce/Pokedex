package com.adridoce.pokedex.data.local.models

import com.google.gson.annotations.SerializedName

data class Sprite(
    @SerializedName("front_default") val imageUrl: String
)