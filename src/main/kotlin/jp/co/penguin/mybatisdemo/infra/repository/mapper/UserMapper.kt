package jp.co.penguin.mybatisdemo.infra.repository.mapper

import jp.co.penguin.mybatisdemo.infra.repository.record.UserRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component

@Mapper
@Component
interface UserMapper {

    @Select("""SELECT * FROM user WHERE email = #{email}""")
    fun findByEmail(email: String): UserRecord
}