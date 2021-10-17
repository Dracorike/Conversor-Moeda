package com.petruciostech.conversordemoeda.data

import com.petruciostech.conversordemoeda.model.Coin
import com.petruciostech.conversordemoeda.model.CoinToList

interface CurrencyDataSource {
    fun getQuoteUSA():Coin
    fun getListCurrencys():CoinToList
}