package com.petruciostech.conversordemoeda.view.recyclerview

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petruciostech.conversordemoeda.R
import com.petruciostech.conversordemoeda.databinding.ItemCurrencyBinding
import com.petruciostech.conversordemoeda.model.CoinToRecyclerView
import com.petruciostech.conversordemoeda.util.tools.*
import com.petruciostech.conversordemoeda.view.MainActivity

class RecyclerCurrency(private val listCurrency:List<CoinToRecyclerView>,
                       application: Application, buttonChoise:Int):
    RecyclerView.Adapter<ViewHolder>() {
    private var sharedPref = application.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
    private val app = application
    private val buttonChoise = buttonChoise
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind.textCurrencytitle.text = listCurrency[position].name
        holder.bind.textCurrencycode.text = listCurrency[position].code
        holder.itemView.setOnClickListener {
            if(buttonChoise == 1){
                with(sharedPref.edit()){
                    putString(SHARED_CODE_STRING_KEY_ONE, listCurrency[position].code)
                    putBoolean(SHARED_BOOLEAN_ONE_KEY, true)
                    commit()
                }
            }else if(buttonChoise == 2){
                with(sharedPref.edit()){
                    putString(SHARED_CODE_STRING_KEY_TWO, listCurrency[position].code)
                    putBoolean(SHARED_BOOLEAN_TWO_KEY, true)
                    commit()
                }
            }
            val intent = Intent(app.applicationContext, MainActivity::class.java)
            app.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listCurrency.size
}

class ViewHolder(itemHolder:View):RecyclerView.ViewHolder(itemHolder){
    val bind = ItemCurrencyBinding.bind(itemView)
}