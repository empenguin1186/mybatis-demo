package jp.co.penguin.mybatisdemo.infra.repository.mapper

import jp.co.penguin.mybatisdemo.infra.repository.record.BookRecord
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Component

@Mapper
@Component
interface BookMapper {

    @Insert("""
        INSERT INTO book VALUES (
            #{id},
            #{title},
            #{author},
            #{releaseDate},
        )
    """)
    fun insert(bookRecord: BookRecord)
}