package com.petruciostech.conversordemoeda.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.petruciostech.conversordemoeda.R
import com.petruciostech.conversordemoeda.databinding.FragmentMainBinding
import com.petruciostech.conversordemoeda.viewmodel.MainFragmentViewModel

class MainFragment : Fragment() {
    private lateinit var bind:FragmentMainBinding
    private lateinit var viewModel:MainFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider
            .AndroidViewModelFactory(activity?.application!!)
            .create(MainFragmentViewModel::class.java)
        initFragment()
        initPriceDollar()
        return bind.root
    }

    private fun initFragment(){
        viewModel.getPriceUsa()
    }

    private fun initPriceDollar(){
        viewModel.usaPrice.observe(viewLifecycleOwner, {
            val dolar = it.quotes.toList()
            bind.textDolarpriceView.text = "R$ " + dolar.find { pred -> pred.first == "USDBRL" }
                ?.second?.format(2)
        })
    }


    fun Float.format(digits:Int) = "%.${digits}f".format(this)
}