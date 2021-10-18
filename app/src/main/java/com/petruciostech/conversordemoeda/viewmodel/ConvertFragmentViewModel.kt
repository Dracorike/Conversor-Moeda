package com.petruciostech.conversordemoeda.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.petruciostech.conversordemoeda.util.tools.*

class ConvertFragmentViewModel(application: Application): AndroidViewModel(application) {
    private var sharedPref = application.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
    val isChoiceOne = sharedPref.getBoolean(SHARED_BOOLEAN_ONE_KEY, false)
    val isChoiceTwo = sharedPref.getBoolean(SHARED_BOOLEAN_TWO_KEY, false)

    fun getCodeChoisedOne():String = sharedPref.getString(SHARED_CODE_STRING_KEY_ONE, "ERRO!")!!
    fun getCodeChoisedTwo():String = sharedPref.getString(SHARED_CODE_STRING_KEY_TWO, "ERRO!")!!
}