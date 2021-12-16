package jp.co.penguin.mybatisdemo.domain.repository

import jp.co.penguin.mybatisdemo.domain.model.BookWithRental

interface BookRepository {
    fun findAllWithRental(): List<BookWithRental>
}