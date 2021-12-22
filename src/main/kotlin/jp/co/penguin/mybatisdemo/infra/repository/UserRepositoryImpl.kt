package jp.co.penguin.mybatisdemo.infra.repository

import jp.co.penguin.mybatisdemo.domain.model.User
import jp.co.penguin.mybatisdemo.domain.repository.UserRepository
import jp.co.penguin.mybatisdemo.infra.repository.mapper.UserMapper
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userMapper: UserMapper
): UserRepository {

    override fun find(email: String): User? {
        val userRecord = userMapper.findByEmail(email)
        return userRecord?.toModel()
    }

    override fun find(id: Long): User? {
        val userRecord = userMapper.findByPrimaryKey(id)
        return userRecord?.toModel()
    }
}