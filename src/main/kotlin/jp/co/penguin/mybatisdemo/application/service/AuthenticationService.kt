package jp.co.penguin.mybatisdemo.application.service

import jp.co.penguin.mybatisdemo.domain.model.User
import jp.co.penguin.mybatisdemo.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository
) {
    fun findUser(email: String): User? {
        return userRepository.find(email)
    }
}