package com.petruciostech.conversordemoeda.data

import com.petruciostech.conversordemoeda.model.Coin

interface CurrencyDataSource {
    fun getQuoteUSA():Coin
}