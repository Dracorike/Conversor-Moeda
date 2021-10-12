package com.petruciostech.conversordemoeda.data

import android.util.Log
import com.petruciostech.conversordemoeda.implementation.CurrencyDataSourceImplementation
import com.petruciostech.conversordemoeda.model.Coin

class Repository(private val dataSourceImplementation: CurrencyDataSourceImplementation) {
    fun getQuoteUSA():Coin = dataSourceImplementation.getQuoteUSA()
}