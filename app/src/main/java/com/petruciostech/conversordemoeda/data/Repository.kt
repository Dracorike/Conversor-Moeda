package com.petruciostech.conversordemoeda.data

import com.petruciostech.conversordemoeda.implementation.CurrencyDataSourceImplementation
import com.petruciostech.conversordemoeda.model.Coin
import com.petruciostech.conversordemoeda.model.CoinToList
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataSourceImplementation: CurrencyDataSourceImplementation
) {
    fun getQuoteUSA():Coin = dataSourceImplementation.getQuoteUSA()
    fun getListCurrencys():CoinToList = dataSourceImplementation.getListCurrencys()
}