package com.petruciostech.conversordemoeda.util.retrofit

import com.petruciostech.conversordemoeda.model.Coin
import com.petruciostech.conversordemoeda.model.CoinToList
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitCurrencyApi {

    //TODO Remove these hardcoded keys access_keys and create new Retrofit interceptor
    @GET("/live?access_key=5ed10cd86dd9f0cb7cf8b7d0fb75e8b1")
    fun getQuoteUSA(): Call<Coin>

    @GET("/list?access_key=5ed10cd86dd9f0cb7cf8b7d0fb75e8b1")
    fun getListCurrencys(): Call<CoinToList>
}