package jp.co.penguin.mybatisdemo.application.service

import jp.co.penguin.mybatisdemo.domain.model.Rental
import jp.co.penguin.mybatisdemo.domain.repository.BookRepository
import jp.co.penguin.mybatisdemo.domain.repository.RentalRepository
import jp.co.penguin.mybatisdemo.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

private const val RENTAL_TERM_DAYS = 14L

@Service
class RentalService(
    private val userRepository: UserRepository,
    private val rentalRepository: RentalRepository,
    private val bookRepository: BookRepository
) {

    @Transactional
    fun startRental(bookId: Long, userId: Long) {
        // ユーザの存在判定
        userRepository.find(userId) ?: throw IllegalArgumentException("該当するユーザが存在しません userId:${userId}")

        // 貸し出し中のチェック
        val book = bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("該当する書籍が存在しません bookId:${bookId}")
        if (book.isRental) throw IllegalStateException("貸し出し中の商品です bookId:${bookId}")

        // 貸し出し処理
        val rentalDateTime = LocalDateTime.now()
        val returnDeadline = rentalDateTime.plusDays(RENTAL_TERM_DAYS)
        val rental = Rental(bookId, userId, rentalDateTime, returnDeadline)
        rentalRepository.startRental(rental)
    }

    @Transactional
    fun endRental(bookId: Long, userId: Long) {
        // ユーザの存在判定
        userRepository.find(userId) ?: throw IllegalArgumentException("該当するユーザが存在しません userId:${userId}")

        // 貸し出し中のチェック
        val book = bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("該当する書籍が存在しません bookId:${bookId}")
        if (!book.isRental) throw IllegalStateException("未貸出の商品です bookId:${bookId}")

        // 貸し出し処理
        rentalRepository.endRental(bookId, userId)
    }
}