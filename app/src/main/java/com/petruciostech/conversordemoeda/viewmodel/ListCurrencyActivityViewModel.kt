package com.petruciostech.conversordemoeda.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petruciostech.conversordemoeda.data.Repository
import com.petruciostech.conversordemoeda.implementation.CurrencyDataSourceImplementation
import com.petruciostech.conversordemoeda.model.CoinToList
import com.petruciostech.conversordemoeda.usecase.UseCaseListCurrency
import com.petruciostech.conversordemoeda.util.retrofit.RetrofitCurrencyTask
import com.petruciostech.conversordemoeda.util.tools.*
import kotlin.coroutines.coroutineContext

class ListCurrencyActivityViewModel(application: Application):AndroidViewModel(application) {
    private val task = RetrofitCurrencyTask()
    private val dataSource = CurrencyDataSourceImplementation(task)
    private val repository = Repository(dataSource)
    private val useCase = UseCaseListCurrency(repository)

    private var _listCurrency = MutableLiveData<CoinToList>()
    val listCurrency:LiveData<CoinToList> get() = _listCurrency

    fun getListOfCurrencys(){
        Thread{
            try {
                _listCurrency.postValue(useCase.invoke())
                Log.i(TAG_SUCCESS_THREAD_LIST, TEXT_SUCCESS_THREAD_LIST)
            }catch (ex:Exception){
                Log.e(TAG_ERROR_THREAD_LIST, TEXT_ERROR_THREAD_LIST, ex)
            }
        }.start()
    }

}