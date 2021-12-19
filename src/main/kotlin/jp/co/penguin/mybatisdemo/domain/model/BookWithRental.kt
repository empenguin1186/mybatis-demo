package jp.co.penguin.mybatisdemo.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

data class BookWithRental(
    private val book: Book,
    private val rental: Rental?
) {
    val id: Long
        get() = book.id

    val title: String
        get() = book.title

    val author: String
        get() = book.author

    val isRental: Boolean
        get() = rental != null

    val releaseDate: LocalDate
        get() = book.releaseDate

    val userId: Long?
        get() = rental?.userId

    val rentalDateTime: LocalDateTime?
        get() = rental?.rentalDateTime

    val rentalDeadline: LocalDateTime?
        get() = rental?.rentalDeadline
}
