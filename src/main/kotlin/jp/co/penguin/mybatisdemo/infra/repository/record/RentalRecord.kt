package jp.co.penguin.mybatisdemo.infra.repository.record

import java.time.LocalDateTime

data class RentalRecord(
    var bookId: Long? = null,
    var userId: Long? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDeadline: LocalDateTime? = null
)