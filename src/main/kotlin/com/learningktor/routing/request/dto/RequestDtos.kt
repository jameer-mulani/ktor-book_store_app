package com.learningktor.routing.request.dto

import io.ktor.server.locations.*

@Location("/book")
data class BookRequestDto(
    val orderBy: String = "",
    val asc: Boolean = true, val limit: Int = 10
) {
    @Location("/{id}")
    data class WithId(val bookRequestDto: BookRequestDto, val id: String)

    @Location("/category/{category}")
    data class WithCategory(val bookRequestDto: BookRequestDto, val category: String)

    @Location("/search/{searchBy}")
    data class WithSearch(val bookRequestDto: BookRequestDto, val searchBy: String)

}