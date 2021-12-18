package jp.co.penguin.mybatisdemo.presentation.controller

import jp.co.penguin.mybatisdemo.application.service.AdminBookService
import jp.co.penguin.mybatisdemo.presentation.form.RegisterBookRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("admin/book")
@CrossOrigin
class AdminBookController(
    private val adminBookService: AdminBookService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterBookRequest) {
        adminBookService.register(request.toModel())
    }
}