package com.adridoce.pokedex.data.local.models

import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("name") val name: String
)