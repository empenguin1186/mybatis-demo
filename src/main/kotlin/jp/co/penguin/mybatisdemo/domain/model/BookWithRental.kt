package jp.co.penguin.mybatisdemo.domain.model

data class BookWithRental(
    private val book: Book,
    private val rental: Rental?
) {
    val id: Long
        get() = book.id

    val title: String
        get() = book.title

    val author: String
        get() = book.author

    val isRental: Boolean
        get() = rental != null
}
