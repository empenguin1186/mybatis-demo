package jp.co.penguin.mybatisdemo.presentation.controller

import jp.co.penguin.mybatisdemo.application.service.BookService
import jp.co.penguin.mybatisdemo.presentation.form.BookInfo
import jp.co.penguin.mybatisdemo.presentation.form.GetBookDetailResponse
import jp.co.penguin.mybatisdemo.presentation.form.GetBookListResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
@CrossOrigin
class BookController(
    private val bookService: BookService
) {

    @GetMapping
    fun getList(): GetBookListResponse {
        val bookList = bookService.getList().map {
            BookInfo(it)
        }
        return GetBookListResponse(bookList)
    }

    @GetMapping("/{book_id}")
    fun getDetail(@PathVariable("book_id") bookId: Long): GetBookDetailResponse {
        val book = bookService.getDetail(bookId)
        return GetBookDetailResponse(book)
    }
}