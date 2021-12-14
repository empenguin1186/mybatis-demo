package jp.co.penguin.mybatisdemo.infra.repository.record

import jp.co.penguin.mybatisdemo.domain.enum.RoleType

data class UserRecord(
    var id: Long? = null,
    var email: String? = null,
    var password: String? = null,
    var name: String? = null,
    var roleType: RoleType? = null
)
