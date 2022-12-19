package com.learningktor.utility

import com.learningktor.data.model.Book
import java.util.*

object AppUtility {

    private var id = 0

    @Synchronized
    private fun generateId() = id++

    fun prepareBooks(count: Int = 10): List<Book> {
        val random = Random()
        val books = arrayListOf<Book>()
        repeat(count) {
            val id = generateId()
            val title = "Book Title : $id"
            val description = """
                Book Description for $id.
                Random Number : ${random.nextInt(Int.MAX_VALUE)}         
                """
            val authorCategoryPair: Pair<String, String> = when {
                id % 2 == 0 -> {
                    Pair("Mr. Dan Brown", "Kids")
                }
                id % 7 == 0 -> {
                    Pair("Mrs. Aryan", "Fantasies")
                }
                id % 11 == 0 -> {
                    Pair("Mr. Porches", "Sci-Fi")
                }
                id % 13 == 0 -> {
                    Pair("Mr. Jonathan Rube", "Horror")
                }
                else -> {
                    Pair("Mrs. Default", "Novel")
                }
            }

            val price = random.nextInt(100)
            val book = Book(
                id = AppUtility.id.toString(),
                title = title,
                description = description,
                author = authorCategoryPair.first,
                category = authorCategoryPair.second,
                price = price.toFloat()
            )
            books.add(book)
        }
        return books
    }

}