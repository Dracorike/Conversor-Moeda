package com.petruciostech.conversordemoeda.util.retrofit

import com.petruciostech.conversordemoeda.model.Coin
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitCurrencyApi {
    @GET("live?access_key=5ed10cd86dd9f0cb7cf8b7d0fb75e8b1")
    fun getQuoteUSA():Call<Coin>
}