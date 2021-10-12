package com.petruciostech.conversordemoeda.usecase

import com.petruciostech.conversordemoeda.data.Repository

class UseCaseQuoteUSA(private val repository: Repository) {
    operator fun invoke() = repository.getQuoteUSA()
}