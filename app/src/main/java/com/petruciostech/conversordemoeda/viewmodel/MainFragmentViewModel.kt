package com.petruciostech.conversordemoeda.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petruciostech.conversordemoeda.model.Coin
import com.petruciostech.conversordemoeda.usecase.UseCaseQuoteUSA
import com.petruciostech.conversordemoeda.util.tools.TAG_ERROR_THREAD_PRICE
import com.petruciostech.conversordemoeda.util.tools.TAG_SUCCESS_THREAD_PRICE
import com.petruciostech.conversordemoeda.util.tools.TEXT_ERROR_THREAD_PRICE
import com.petruciostech.conversordemoeda.util.tools.TEXT_SUCCESS_THREAD_PRICE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val useCase: UseCaseQuoteUSA
) : ViewModel() {

    private var _usaPrice = MutableLiveData<Coin>()
    val usaPrice: LiveData<Coin> get() = _usaPrice

    fun initViewModel() {
        getPriceUsa()
    }

    private fun getPriceUsa() {
        Thread {
            try {
                _usaPrice.postValue(useCase.invoke())
                Log.i(TAG_SUCCESS_THREAD_PRICE, TEXT_SUCCESS_THREAD_PRICE)
            } catch (ex: Exception) {
                Log.e(TAG_ERROR_THREAD_PRICE, TEXT_ERROR_THREAD_PRICE, ex)
            }
        }.start()
    }

    private fun Float.format(digits: Int) = "%.${digits}f".format(this)

    fun dollarPricePrint(dollar: List<Pair<String, Float>>): String =
        "RS ${dollar.find { pred -> pred.first == "USDBRL" }?.second?.format(2)}"

}