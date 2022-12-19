package com.learningktor.routing

import com.learningktor.manager.BookManager
import com.learningktor.routing.request.dto.BookRequestDto
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.bookRouting() {

    val bookManager = BookManager()


    get<BookRequestDto> {
        call.respond(bookManager.getBooks(it.orderBy, it.asc, it.limit))
    }

    get<BookRequestDto.WithId> {
        call.respond(bookManager.getBooksById(it.id))
    }

    get<BookRequestDto.WithCategory> {
        call.respondText { "under construction" }
    }

    get<BookRequestDto.WithSearch> {
        call.respondText { "under construction" }
    }


}