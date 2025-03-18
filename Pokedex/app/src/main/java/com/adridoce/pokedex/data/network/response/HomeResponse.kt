package com.adridoce.pokedex.data.network.response

import com.adridoce.pokedex.data.local.models.Pokemon
import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("count") val count:Int,
    @SerializedName("next") val next:String?,
    @SerializedName("previous") val previous:String?,
    @SerializedName("results") val results:List<Pokemon>
)


