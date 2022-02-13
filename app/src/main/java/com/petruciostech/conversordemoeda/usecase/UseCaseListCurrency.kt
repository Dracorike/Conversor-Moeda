package com.petruciostech.conversordemoeda.usecase

import com.petruciostech.conversordemoeda.data.Repository
import javax.inject.Inject

class UseCaseListCurrency @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() = repository.getListCurrencys()
}