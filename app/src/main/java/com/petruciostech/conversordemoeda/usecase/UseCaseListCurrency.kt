package com.petruciostech.conversordemoeda.usecase

import com.petruciostech.conversordemoeda.data.Repository

class UseCaseListCurrency(private val repository: Repository) {
    operator fun invoke() = repository.getListCurrencys()
}