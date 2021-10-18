package com.petruciostech.conversordemoeda.view

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.petruciostech.conversordemoeda.databinding.FragmentConvertBinding
import com.petruciostech.conversordemoeda.util.tools.INTENT_EXTRA_NUMBER_BUTTON
import com.petruciostech.conversordemoeda.viewmodel.ConvertFragmentViewModel

class ConvertFragment : Fragment() {
    private lateinit var bind:FragmentConvertBinding
    private lateinit var viewModel:ConvertFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentConvertBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider
            .AndroidViewModelFactory(activity?.application as Application)
            .create(ConvertFragmentViewModel::class.java)
        initComponent()
        return bind.root
    }

    private fun initComponent(){
        if(viewModel.isChoiceOne) bind.buttonChoisecurrencyOne.text = viewModel.getCodeChoisedOne()
        if(viewModel.isChoiceTwo) bind.buttonChoisecurrencyTwo.text = viewModel.getCodeChoisedTwo()
        bind.buttonChoisecurrencyOne.setOnClickListener { setActivityCurrencys(1) }
        bind.buttonChoisecurrencyTwo.setOnClickListener { setActivityCurrencys(2) }
    }

    private fun setActivityCurrencys(button:Int){
        val intent = Intent(activity?.applicationContext, ListCurrencyActivity::class.java)
        intent.putExtra(INTENT_EXTRA_NUMBER_BUTTON, button)
        startActivity(intent)
    }



}