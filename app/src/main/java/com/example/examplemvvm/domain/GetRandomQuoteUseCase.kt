package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.domain.model.Quote
import com.example.examplemvvm.domain.model.toDomain
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): Quote?{
        val quotes = repository.getQuotesFromDatabase()
        quotes.let {
            if(it.isNotEmpty()){
                val randomNumber = (it.indices).random()
                return it[randomNumber]
            } else {
                return null
            }
        }
    }
}