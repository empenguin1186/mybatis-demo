package jp.co.penguin.mybatisdemo.presentation.controller

import jp.co.penguin.mybatisdemo.application.service.AdminBookService
import jp.co.penguin.mybatisdemo.presentation.form.RegisterBookRequest
import jp.co.penguin.mybatisdemo.presentation.form.UpdateBookRequest
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// TODO Role ベースのアクセス制御が可能になったら BookController と統合する
@RestController
@RequestMapping("admin/book")
@CrossOrigin
class AdminBookController(
    private val adminBookService: AdminBookService
) {
    @PostMapping
    fun register(@RequestBody request: RegisterBookRequest) {
        adminBookService.register(request.toModel())
    }

    @PutMapping("/{book_id}")
    fun update(@PathVariable("book_id") bookId: Long, @RequestBody request: UpdateBookRequest) {
        adminBookService.update(bookId, request.title, request.author, request.releaseDate)
    }

    @DeleteMapping("/{book_id}")
    fun delete(@PathVariable("book_id") bookId: Long) {
        adminBookService.delete(bookId)
    }
}