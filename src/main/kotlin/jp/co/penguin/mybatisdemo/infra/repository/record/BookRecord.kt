package jp.co.penguin.mybatisdemo.infra.repository.record

import jp.co.penguin.mybatisdemo.domain.model.Book
import java.time.LocalDate

data class BookRecord(
    var id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null
) {
    companion object {
        fun createByModel(book: Book): BookRecord {
            return book.let {
                BookRecord(
                    it.id,
                    it.title,
                    it.author,
                    it.releaseDate
                )
            }
        }
    }
}
