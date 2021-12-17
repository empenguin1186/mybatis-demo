package jp.co.penguin.mybatisdemo.presentation.form

import jp.co.penguin.mybatisdemo.domain.model.BookWithRental

data class GetBookListResponse(val bookList: List<BookInfo>)

data class BookInfo(
    val id: Long,
    val title: String,
    val author: String,
    val isRental: Boolean
) {
    constructor(model: BookWithRental) : this(
        model.id,
        model.title,
        model.author,
        model.isRental
    )
}