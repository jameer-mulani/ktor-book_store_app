package com.learningktor.data.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class Book(
    val id: String,
    val title: String,
    val description: String,
    val author: String,
    val price: Float,
    val category: String,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAtTime: LocalDateTime = LocalDateTime.now()
)

data class BookCategory(
    val id : Int,
    val name : String)
