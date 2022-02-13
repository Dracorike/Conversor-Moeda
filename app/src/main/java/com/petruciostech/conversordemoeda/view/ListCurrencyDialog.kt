package com.petruciostech.conversordemoeda.view

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.petruciostech.conversordemoeda.model.CoinToRecyclerView
import com.petruciostech.conversordemoeda.viewmodel.ConvertFragmentViewModel
import java.lang.IllegalStateException

class ListCurrencyDialog(private val listCurrency:List<CoinToRecyclerView>): DialogFragment() {
    private val viewModel:ConvertFragmentViewModel by activityViewModels()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Lista de moedas")
                .setItems(viewModel.sortListCurrency(listCurrency)) { _, which ->
                    when(viewModel.whichButton.value){
                        1 -> viewModel.setCodeOne(listCurrency[which].code)
                        2 -> viewModel.setCodeTwo(listCurrency[which].code)
                    }
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}