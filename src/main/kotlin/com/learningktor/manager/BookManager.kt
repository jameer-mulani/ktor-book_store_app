package com.learningktor.manager

import com.learningktor.data.model.Book
import com.learningktor.utility.AppUtility
import kotlin.reflect.full.declaredMemberProperties

class BookManager {
    private val books = AppUtility.prepareBooks(20)

    private fun getAllBooks() = books

    fun getBooks(orderBy: String, asc: Boolean, limit: Int): List<Book> {
        if (orderBy.isEmpty())
            return getAllBooks()

        val foundMember = Book::class.declaredMemberProperties.find {
            it.name == orderBy
        }

        return if (foundMember != null) {
            val filteredList: List<Book> = if (asc) {
                books.sortedBy { foundMember.name }
            } else {
                books.sortedByDescending { foundMember.name }
            }
            filteredList.subList(0, limit)
        } else {
            getAllBooks()
        }

    }

    fun getBooksById(id: String): Book {
        val found = books.find {
            it.id == id
        }
        return found!!
    }

}