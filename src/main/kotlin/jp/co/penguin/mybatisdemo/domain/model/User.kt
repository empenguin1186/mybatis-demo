package jp.co.penguin.mybatisdemo.domain.model

import jp.co.penguin.mybatisdemo.domain.enum.RoleType

data class User(
    val id: Long,
    val email: String,
    val password: String,
    val name: String,
    val roleType: RoleType
)
