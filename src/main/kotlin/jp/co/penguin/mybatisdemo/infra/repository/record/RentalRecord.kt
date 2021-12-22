package jp.co.penguin.mybatisdemo.infra.repository.record

import jp.co.penguin.mybatisdemo.domain.model.Rental
import java.time.LocalDateTime

data class RentalRecord(
    var bookId: Long? = null,
    var userId: Long? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDeadline: LocalDateTime? = null
){
    companion object {
        fun createByModel(rental: Rental): RentalRecord {
            return RentalRecord(
                rental.bookId,
                rental.userId,
                rental.rentalDateTime,
                rental.rentalDeadline,
            )
        }
    }
}