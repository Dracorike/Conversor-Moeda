package com.petruciostech.conversordemoeda.model

import com.google.gson.annotations.SerializedName

data class CoinToList(
    @SerializedName("success") val success: Boolean,
    @SerializedName("currencies") val currencies: Map<String, String>
)