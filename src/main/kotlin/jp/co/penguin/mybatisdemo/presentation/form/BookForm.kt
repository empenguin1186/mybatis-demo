package jp.co.penguin.mybatisdemo.presentation.form

import jp.co.penguin.mybatisdemo.domain.model.Book
import jp.co.penguin.mybatisdemo.domain.model.BookWithRental
import java.time.LocalDate
import java.time.LocalDateTime

data class GetBookListResponse(val bookList: List<BookInfo>)

data class BookInfo(
    val id: Long,
    val title: String,
    val author: String,
    val isRental: Boolean
) {
    constructor(model: BookWithRental) : this(
        model.id,
        model.title,
        model.author,
        model.isRental
    )
}

data class GetBookDetailResponse(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate,
    val rentalInfo: RentalInfo?
) {
    constructor(model: BookWithRental) : this(
        model.id,
        model.title,
        model.author,
        model.releaseDate,
        if (model.isRental) RentalInfo(
            model.userId!!,
            model.rentalDateTime!!,
            model.rentalDeadline!!
        ) else null
    )
}

data class RentalInfo(
    val userId: Long,
    val rentalDatetime: LocalDateTime,
    val rentalDeadline: LocalDateTime,
)

data class RegisterBookRequest(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate
) {
    fun toModel() = Book(id, title, author, releaseDate)
}