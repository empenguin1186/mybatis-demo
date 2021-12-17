package jp.co.penguin.mybatisdemo.presentation.controller

import jp.co.penguin.mybatisdemo.application.service.BookService
import jp.co.penguin.mybatisdemo.presentation.form.BookInfo
import jp.co.penguin.mybatisdemo.presentation.form.GetBookDetailResponse
import jp.co.penguin.mybatisdemo.presentation.form.GetBookListResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
@CrossOrigin
class BookController(
    private val bookService: BookService
) {

    // TODO パスは要検討
    @GetMapping("/list")
    fun getList(): GetBookListResponse {
        val bookList = bookService.getList().map {
            BookInfo(it)
        }
        return GetBookListResponse(bookList)
    }

    // TODO パスは要検討
    @GetMapping("/detail/{book_id}")
    fun getDetail(@PathVariable("book_id") bookId: Long): GetBookDetailResponse {
        val book = bookService.getDetail(bookId)
        return GetBookDetailResponse(book)
    }
}