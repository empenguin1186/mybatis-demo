package jp.co.penguin.mybatisdemo.domain.repository

import jp.co.penguin.mybatisdemo.domain.model.Book
import jp.co.penguin.mybatisdemo.domain.model.BookWithRental
import java.time.LocalDate

interface BookRepository {
    fun findAllWithRental(): List<BookWithRental>
    fun findWithRental(id: Long): BookWithRental?
    fun register(book: Book)
    fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?)
}