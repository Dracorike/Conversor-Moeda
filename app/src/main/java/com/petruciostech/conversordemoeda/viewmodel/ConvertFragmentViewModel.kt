package com.petruciostech.conversordemoeda.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.petruciostech.conversordemoeda.data.Repository
import com.petruciostech.conversordemoeda.implementation.CurrencyDataSourceImplementation
import com.petruciostech.conversordemoeda.model.CoinToList
import com.petruciostech.conversordemoeda.model.CoinToRecyclerView
import com.petruciostech.conversordemoeda.usecase.UseCaseListCurrency
import com.petruciostech.conversordemoeda.util.retrofit.RetrofitCurrencyTask
import com.petruciostech.conversordemoeda.util.tools.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConvertFragmentViewModel @Inject constructor(
    private val useCase:UseCaseListCurrency
): ViewModel() {
    /*private val task = RetrofitCurrencyTask()
    private val dataSource = CurrencyDataSourceImplementation(task)
    private val repository = Repository(dataSource)
    private val useCase = UseCaseListCurrency(repository)*/

    private var _codeOne = MutableLiveData<String>()
    val codeOne:LiveData<String> get() = _codeOne
    private var _codeTwo = MutableLiveData<String>()
    val codeTwo:LiveData<String> get() = _codeTwo
    private var _whichButton = MutableLiveData<Int>()
    val whichButton:LiveData<Int> get() = _whichButton
    private var _listCurrency = MutableLiveData<CoinToList>()
    val listCurrency:LiveData<CoinToList> get() = _listCurrency

    fun setCodeOne(code:String){
        _codeOne.value = code
    }

    fun setCodeTwo(code:String){
        _codeTwo.value = code
    }

    fun choisedButton(choice:Int){
        _whichButton.value = choice
    }

    fun sortListCurrency(list:List<CoinToRecyclerView>): Array<String> {
        val coinsName = arrayListOf<String>()
        list.forEach { coinsName.add(it.name) }
        return Array(list.size) { i -> coinsName[i] }
    }

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

    fun cointolistToCointorecyclerview(coinToList: CoinToList):List<CoinToRecyclerView>{
        var listCoins = coinToList.currencies.toList()
        var toRecyclerView = arrayListOf<CoinToRecyclerView>()
        listCoins.forEach { toRecyclerView.add(CoinToRecyclerView(it.first, it.second)) }
        return toRecyclerView
    }
}