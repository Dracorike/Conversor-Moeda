package com.petruciostech.conversordemoeda.model

import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("source")
    val source:String,
    @SerializedName("quotes")
    val quotes:Map<String, Float>
)