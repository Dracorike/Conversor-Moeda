package com.petruciostech.conversordemoeda.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.petruciostech.conversordemoeda.databinding.ActivityListCurrencyBinding
import com.petruciostech.conversordemoeda.model.CoinToList
import com.petruciostech.conversordemoeda.model.CoinToRecyclerView
import com.petruciostech.conversordemoeda.view.recyclerview.RecyclerCurrency
import com.petruciostech.conversordemoeda.viewmodel.ListCurrencyActivityViewModel

class ListCurrencyActivity : AppCompatActivity() {
    private lateinit var bind:ActivityListCurrencyBinding
    private lateinit var viewModel:ListCurrencyActivityViewModel
    private var listCurrency:CoinToList? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityListCurrencyBinding.inflate(layoutInflater)
        setContentView(bind.root)
        viewModel = ViewModelProvider
            .AndroidViewModelFactory(application)
            .create(ListCurrencyActivityViewModel::class.java)
        viewModel.getListOfCurrencys()
        initList()
    }

    private fun initList(){
        viewModel.listCurrency.observe(this, {
            listCurrency = it
            val coins = listCurrency?.currencies?.toList()
            val coinList = arrayListOf<CoinToRecyclerView>()
            coins?.forEach {
                coinList.add(CoinToRecyclerView(it.first, it.second))
            }
            bind.recyclerCurrencylist.apply {
                adapter = RecyclerCurrency(coinList)
                layoutManager = LinearLayoutManager(context)
            }
        })
    }

}