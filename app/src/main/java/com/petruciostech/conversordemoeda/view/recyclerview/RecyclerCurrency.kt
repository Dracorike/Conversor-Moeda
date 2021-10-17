package com.petruciostech.conversordemoeda.view.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petruciostech.conversordemoeda.R
import com.petruciostech.conversordemoeda.databinding.ItemCurrencyBinding
import com.petruciostech.conversordemoeda.model.CoinToRecyclerView

class RecyclerCurrency(private val listCurrency:List<CoinToRecyclerView>):
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind.textCurrencytitle.text = listCurrency[position].name
        holder.bind.textCurrencycode.text = listCurrency[position].code
    }

    override fun getItemCount(): Int = listCurrency.size
}

class ViewHolder(itemHolder:View):RecyclerView.ViewHolder(itemHolder){
    val bind = ItemCurrencyBinding.bind(itemView)
}