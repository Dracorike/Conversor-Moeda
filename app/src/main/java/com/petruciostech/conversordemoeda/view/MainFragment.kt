package com.petruciostech.conversordemoeda.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.petruciostech.conversordemoeda.databinding.FragmentMainBinding
import com.petruciostech.conversordemoeda.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var bind: FragmentMainBinding
    private val viewModel: MainFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentMainBinding.inflate(inflater, container, false)
        initFragment()
        initPriceDollar()
        return bind.root
    }

    private fun initFragment() {
        viewModel.initViewModel()
    }

    private fun initPriceDollar() {
        viewModel.usaPrice.observe(viewLifecycleOwner) {
            val dollar = it.quotes.toList()
            bind.textDolarpriceView.text = viewModel.dollarPricePrint(dollar)
        }
    }
}