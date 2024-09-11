package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.database.dao.QuoteDao
import com.example.examplemvvm.data.database.entities.toDatabase
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.domain.model.Quote
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor( // Sólo se usa una vez cuando abrimos la app para obtener las quotes de la api
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes() // borrar la tabla de la base de datos para cada vez que se abra la app y se recupere de la api
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes

        } else {
            return repository.getQuotesFromDatabase()

        }


    }

}