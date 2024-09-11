package com.example.examplemvvm.domain.model

import com.example.examplemvvm.data.database.entities.QuoteEntity
import com.example.examplemvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)
// Modelo de datos para que trabaje presentation y domain, para no usar el model de data
//aqui va el mapper porque vamos a transformar de QuoteModel a Quote

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)




