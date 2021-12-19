package jp.co.penguin.mybatisdemo.application.service

import jp.co.penguin.mybatisdemo.domain.model.Book
import jp.co.penguin.mybatisdemo.domain.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class AdminBookService(
    private val bookRepository: BookRepository
) {
    @Transactional
    fun register(book: Book) {
        bookRepository.findWithRental(book.id)?.let {
            throw IllegalArgumentException("すでに存在する書籍ID: ${book.id}")
        }
        bookRepository.register(book)
    }

    @Transactional
    fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?) {
        bookRepository.findWithRental(id) ?: throw IllegalArgumentException("存在しない書籍ID: $id")
        bookRepository.update(id, title, author, releaseDate)
    }
}