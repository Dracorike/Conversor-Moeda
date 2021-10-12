package com.petruciostech.conversordemoeda.util.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://api.currencylayer.com/"

class RetrofitCurrencyTask {
    private val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun task():RetrofitCurrencyApi = retrofit.create(RetrofitCurrencyApi::class.java)
}