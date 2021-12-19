package jp.co.penguin.mybatisdemo.infra.repository.record

import jp.co.penguin.mybatisdemo.domain.model.Book
import jp.co.penguin.mybatisdemo.domain.model.BookWithRental
import jp.co.penguin.mybatisdemo.domain.model.Rental
import java.time.LocalDate
import java.time.LocalDateTime

data class BookWithRentalRecord(
    var id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null,
    var userId: Long? = null,
    var rentalDateTime: LocalDateTime? = null,
    var returnDeadline: LocalDateTime? = null
) {
    fun toModel(): BookWithRental {
        val book = Book(
            this.id!!,
            this.title!!,
            this.author!!,
            this.releaseDate!!
        )

        val rental = this.userId?.let {
            Rental(
                this.id!!,
                this.userId!!,
                this.rentalDateTime!!,
                this.returnDeadline!!
            )
        }
        return BookWithRental(book, rental)
    }
}
