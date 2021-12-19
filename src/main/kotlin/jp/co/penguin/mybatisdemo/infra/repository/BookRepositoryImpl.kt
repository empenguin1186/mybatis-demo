package jp.co.penguin.mybatisdemo.infra.repository

import jp.co.penguin.mybatisdemo.domain.model.Book
import jp.co.penguin.mybatisdemo.domain.model.BookWithRental
import jp.co.penguin.mybatisdemo.domain.repository.BookRepository
import jp.co.penguin.mybatisdemo.infra.repository.mapper.BookMapper
import jp.co.penguin.mybatisdemo.infra.repository.mapper.BookWithRentalMapper
import jp.co.penguin.mybatisdemo.infra.repository.record.BookRecord
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class BookRepositoryImpl(
    private val bookWithRentalMapper: BookWithRentalMapper,
    private val bookMapper: BookMapper
) : BookRepository {

    override fun findAllWithRental(): List<BookWithRental> {
        return bookWithRentalMapper.select().map { it.toModel() }
    }

    override fun findWithRental(id: Long): BookWithRental? {
        return bookWithRentalMapper.selectByPrimaryKey(id)?.let {
            it.toModel()
        }
    }

    override fun register(book: Book) {
        BookRecord.createByModel(book).apply {
            bookMapper.insert(this)
        }
    }

    override fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?) {
        bookMapper.update(id, title, author, releaseDate)
    }

    override fun delete(id: Long) {
        bookMapper.delete(id)
    }
}