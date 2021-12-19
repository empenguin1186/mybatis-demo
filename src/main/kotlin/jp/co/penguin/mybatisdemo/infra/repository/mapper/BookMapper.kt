package jp.co.penguin.mybatisdemo.infra.repository.mapper

import jp.co.penguin.mybatisdemo.infra.repository.record.BookRecord
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Update
import org.springframework.stereotype.Component
import java.time.LocalDate

@Mapper
@Component
interface BookMapper {

    @Insert("""
        INSERT INTO book VALUES (
            #{id},
            #{title},
            #{author},
            #{releaseDate}
        )
    """)
    fun insert(bookRecord: BookRecord)

    @Update("""
        UPDATE book SET
           title = #{title},
           author = #{author},
           release_date = #{releaseDate}
        WHERE id = #{id}   
    """)
    fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?)
}