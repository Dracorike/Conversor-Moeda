package com.petruciostech.conversordemoeda

import com.petruciostech.conversordemoeda.model.CoinToList
import com.petruciostech.conversordemoeda.model.CoinToRecyclerView
import com.petruciostech.conversordemoeda.viewmodel.ConvertFragmentViewModel
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import org.junit.Test

class ConvertFragmentViewModelTest {
    private val viewModelTest = ConvertFragmentViewModel()

    @Test
    fun `Testing the function sortListCurrency`(){
        val listCurrency:List<CoinToRecyclerView> = arrayListOf(
            CoinToRecyclerView("CON", "Coin One"),
            CoinToRecyclerView("COT", "Coin Two"),
            CoinToRecyclerView("CTR", "Coin Three")
        )

        assertEquals(3, viewModelTest.sortListCurrency(listCurrency).size)
        assertEquals("Coin One", viewModelTest.sortListCurrency(listCurrency)[0])
        assertEquals("Coin Three", viewModelTest.sortListCurrency(listCurrency)[2])
    }

    @Test
    fun `Testin the fuction cointolistToCointorecyclerview`(){
        val mapCoin = HashMap<String, String>()
        mapCoin["CON"] = "Coin One"
        mapCoin["COT"] = "Coin Two"
        mapCoin["CTR"] = "Coin Three"
        val coinList = CoinToList(true, mapCoin)
        val listDone = viewModelTest.cointolistToCointorecyclerview(coinList)

        assertEquals(3, listDone.size)
        assertEquals("CON", listDone[1].code)
        assertEquals("Coin Two", listDone[2].name)
    }
}