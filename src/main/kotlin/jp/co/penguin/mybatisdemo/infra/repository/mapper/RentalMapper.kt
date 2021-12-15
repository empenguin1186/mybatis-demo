package jp.co.penguin.mybatisdemo.infra.repository.mapper

import jp.co.penguin.mybatisdemo.infra.repository.record.RentalRecord
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Component

@Mapper
@Component
interface RentalMapper {

    @Insert("""
        INSERT INTO rental VALUES(
            #{bookId},
            #{userId},
            #{rentalDatetime},
            #{returnDeadline}
        )
    """)
    fun insert(rentalRecord: RentalRecord)
}