package com.petruciostech.conversordemoeda.implementation

import android.util.Log
import com.petruciostech.conversordemoeda.data.CurrencyDataSource
import com.petruciostech.conversordemoeda.model.Coin
import com.petruciostech.conversordemoeda.util.retrofit.RetrofitCurrencyTask
import com.petruciostech.conversordemoeda.util.tools.*
import com.petruciostech.conversordemoeda.R


class CurrencyDataSourceImplementation(private val task:RetrofitCurrencyTask):
CurrencyDataSource{
    override fun getQuoteUSA(): Coin {
        var coinReturn:Coin? = null
        try {
            val response = task.task().getQuoteUSA().execute()
            if (response.isSuccessful){
                val coin = response.body()
                coinReturn = coin
                Log.i(TAG_SUCESS_RESPONSE, TEXT_SUCESS_RESPONSE)
            }else{
                Log.e(TAG_ERROR_RESPONSE, TEXT_ERROR_RESPONSE)
            }
        }catch (ex:Exception){
            Log.e(TAG_ERROR_RESPONSE, TEXT_ERROR_RESPONSE, ex)
        }
        return coinReturn!!
    }

}