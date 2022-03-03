package com.petruciostech.conversordemoeda.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.petruciostech.conversordemoeda.databinding.FragmentConvertBinding
import com.petruciostech.conversordemoeda.viewmodel.ConvertFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConvertFragment : Fragment() {
    private lateinit var bind: FragmentConvertBinding
    private val viewModel: ConvertFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentConvertBinding.inflate(inflater, container, false)
        viewModel.getListOfCurrencys()
        initComponent()
        return bind.root
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(context, "Olá", Toast.LENGTH_LONG).show()

    }

    private fun initComponent() {
        viewModel.codeOne.observe(viewLifecycleOwner) { codeOne ->
            bind.buttonChoisecurrencyOne.text = codeOne
        }
        viewModel.codeTwo.observe(viewLifecycleOwner) { codeTwo ->
            bind.buttonChoisecurrencyTwo.text = codeTwo
        }

        bind.buttonChoisecurrencyOne.setOnClickListener {
            showDialog()
            viewModel.choisedButton(1)
        }
        bind.buttonChoisecurrencyTwo.setOnClickListener {
            showDialog()
            viewModel.choisedButton(2)
        }
    }

    private fun showDialog() {
        viewModel.listCurrency.observe(viewLifecycleOwner) { listCurrency ->
            val newFrag = ListCurrencyDialog(viewModel.cointolistToCointorecyclerview(listCurrency))
            newFrag.show(parentFragmentManager, "missiles")
        }
    }

}