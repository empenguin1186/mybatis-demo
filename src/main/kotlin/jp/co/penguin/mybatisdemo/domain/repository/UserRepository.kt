package jp.co.penguin.mybatisdemo.domain.repository

import jp.co.penguin.mybatisdemo.domain.model.User

interface UserRepository {
    fun find(email: String): User?
}