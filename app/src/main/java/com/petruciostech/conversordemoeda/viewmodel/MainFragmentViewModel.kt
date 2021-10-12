package com.petruciostech.conversordemoeda.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petruciostech.conversordemoeda.data.Repository
import com.petruciostech.conversordemoeda.implementation.CurrencyDataSourceImplementation
import com.petruciostech.conversordemoeda.model.Coin
import com.petruciostech.conversordemoeda.usecase.UseCaseQuoteUSA
import com.petruciostech.conversordemoeda.util.retrofit.RetrofitCurrencyTask
import com.petruciostech.conversordemoeda.util.tools.TAG_ERROR_THREAD_PRICE
import com.petruciostech.conversordemoeda.util.tools.TAG_SUCESS_THREAD_PRICE
import com.petruciostech.conversordemoeda.util.tools.TEXT_ERROR_THREAD_PRICE
import com.petruciostech.conversordemoeda.util.tools.TEXT_SUCESS_THREAD_PRICE

class MainFragmentViewModel:ViewModel() {
    private val task = RetrofitCurrencyTask()
    private val dataSource = CurrencyDataSourceImplementation(task)
    private val repository = Repository(dataSource)
    private val useCase = UseCaseQuoteUSA(repository)

    private var _usaPrice = MutableLiveData<Coin>()
    val usaPrice:LiveData<Coin> get() = _usaPrice

    fun getPriceUsa(){
        Thread {
            try {
                _usaPrice.postValue(useCase.invoke())
                Log.i(TAG_SUCESS_THREAD_PRICE, TEXT_SUCESS_THREAD_PRICE)
            }catch (ex:Exception){
                Log.e(TAG_ERROR_THREAD_PRICE, TEXT_ERROR_THREAD_PRICE, ex)
            }
        }.start()
    }

}