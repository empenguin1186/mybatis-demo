package jp.co.penguin.mybatisdemo.domain.model

import java.time.LocalDateTime

data class Rental(
    val bookId: Long,
    val userId: Long,
    val rentalDateTime: LocalDateTime,
    val rentalDeadline: LocalDateTime
)
