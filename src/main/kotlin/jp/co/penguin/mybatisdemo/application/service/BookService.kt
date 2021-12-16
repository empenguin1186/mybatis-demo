package jp.co.penguin.mybatisdemo.application.service

import jp.co.penguin.mybatisdemo.domain.model.BookWithRental
import jp.co.penguin.mybatisdemo.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<BookWithRental> {
        return bookRepository.findAllWithRental()
    }
}