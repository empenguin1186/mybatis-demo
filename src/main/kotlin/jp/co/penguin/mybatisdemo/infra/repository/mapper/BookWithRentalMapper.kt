package jp.co.penguin.mybatisdemo.infra.repository.mapper

import jp.co.penguin.mybatisdemo.infra.repository.record.BookWithRentalRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component

@Mapper
@Component
interface BookWithRentalMapper {

    @Select("""
        SELECT
            b.id,
            b.title,
            b.author,
            b.release_date,
            r.user_id,
            r.rental_datetime,
            r.return_deadline
        FROM book b LEFT JOIN rental r
        ON b.id = r.book_id
    """)
    fun select(): List<BookWithRentalRecord>
}