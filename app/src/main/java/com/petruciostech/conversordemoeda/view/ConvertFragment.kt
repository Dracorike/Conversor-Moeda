package com.petruciostech.conversordemoeda.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petruciostech.conversordemoeda.R
import com.petruciostech.conversordemoeda.databinding.FragmentConvertBinding

class ConvertFragment : Fragment() {
    private lateinit var bind:FragmentConvertBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentConvertBinding.inflate(inflater, container, false)
        initComponent()
        return bind.root
    }

    private fun initComponent(){
        bind.buttonChoisecurrencyOne.setOnClickListener { setActivityCurrencys() }
        bind.buttonChoisecurrencyTwo.setOnClickListener { setActivityCurrencys() }
    }

    private fun setActivityCurrencys(){
        val intent = Intent(activity?.applicationContext, ListCurrencyActivity::class.java)
        startActivity(intent)
    }

}