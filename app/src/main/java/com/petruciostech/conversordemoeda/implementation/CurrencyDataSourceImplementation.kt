package com.petruciostech.conversordemoeda.implementation

import android.util.Log
import com.petruciostech.conversordemoeda.data.CurrencyDataSource
import com.petruciostech.conversordemoeda.model.Coin
import com.petruciostech.conversordemoeda.util.tools.*
import com.petruciostech.conversordemoeda.model.CoinToList
import com.petruciostech.conversordemoeda.util.retrofit.RetrofitCurrencyApi
import javax.inject.Inject

class CurrencyDataSourceImplementation @Inject constructor(
    private val task: RetrofitCurrencyApi
) : CurrencyDataSource {

    override fun getQuoteUSA(): Coin {
        var coinReturn: Coin? = null
        try {
            val response = task.getQuoteUSA().execute()
            if (response.isSuccessful) {
                val coin = response.body()
                coinReturn = coin
                Log.i(TAG_SUCCESS_RESPONSE, TEXT_SUCCESS_RESPONSE)
            } else {
                Log.e(TAG_ERROR_RESPONSE, TEXT_ERROR_RESPONSE)
            }
        } catch (ex: Exception) {
            Log.e(TAG_ERROR_RESPONSE, TEXT_ERROR_RESPONSE, ex)
        }
        return coinReturn!!
    }

    override fun getListCurrencys(): CoinToList {
        var coinReturn: CoinToList? = null
        try {
            val response = task.getListCurrencys().execute()
            if (response.isSuccessful) {
                coinReturn = response.body()
                Log.i(TAG_SUCCESS_RESPONSE, TEXT_SUCCESS_RESPONSE)
            } else {
                Log.e(TAG_ERROR_RESPONSE, TEXT_ERROR_RESPONSE)
            }
        } catch (ex: Exception) {
            Log.e(TAG_ERROR_RESPONSE, TEXT_ERROR_RESPONSE, ex)
        }
        return coinReturn!!
    }

}