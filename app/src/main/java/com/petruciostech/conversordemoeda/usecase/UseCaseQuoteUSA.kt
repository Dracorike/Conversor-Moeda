package com.petruciostech.conversordemoeda.usecase

import com.petruciostech.conversordemoeda.data.Repository
import javax.inject.Inject

class UseCaseQuoteUSA @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() = repository.getQuoteUSA()
}