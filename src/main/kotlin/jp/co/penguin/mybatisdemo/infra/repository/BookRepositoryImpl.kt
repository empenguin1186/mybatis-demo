package jp.co.penguin.mybatisdemo.infra.repository

import jp.co.penguin.mybatisdemo.domain.model.Book
import jp.co.penguin.mybatisdemo.domain.model.BookWithRental
import jp.co.penguin.mybatisdemo.domain.model.Rental
import jp.co.penguin.mybatisdemo.domain.repository.BookRepository
import jp.co.penguin.mybatisdemo.infra.repository.mapper.BookWithRentalMapper
import jp.co.penguin.mybatisdemo.infra.repository.record.BookWithRentalRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class BookRepositoryImpl(
    private val bookWithRentalMapper: BookWithRentalMapper
) : BookRepository {

    override fun findAllWithRental(): List<BookWithRental> {
        return bookWithRentalMapper.select().map { toModel(it) }
    }

    private fun toModel(record: BookWithRentalRecord): BookWithRental {
        val book = Book(
            record.id!!,
            record.title!!,
            record.author!!,
            record.releaseDate!!
        )

        val rental = record.userId?.let {
            Rental(
                record.id!!,
                record.userId!!,
                record.rentalDateTime!!,
                record.returnDeadline!!
            )
        }
        return BookWithRental(book, rental)
    }
}