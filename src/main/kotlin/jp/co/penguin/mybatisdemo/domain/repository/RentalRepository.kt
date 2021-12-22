package jp.co.penguin.mybatisdemo.domain.repository

import jp.co.penguin.mybatisdemo.domain.model.Rental

interface RentalRepository {
    fun startRental(rental: Rental)
    fun endRental(bookId: Long, userId: Long)
}