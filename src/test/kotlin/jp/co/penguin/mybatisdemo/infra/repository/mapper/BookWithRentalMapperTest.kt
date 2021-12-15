package jp.co.penguin.mybatisdemo.infra.repository.mapper

import jp.co.penguin.mybatisdemo.infra.repository.record.BookRecord
import jp.co.penguin.mybatisdemo.infra.repository.record.RentalRecord
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import java.time.LocalDate
import java.time.LocalDateTime

@MybatisTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class BookWithRentalMapperTest {

    @Autowired
    private lateinit var bookWithRentalMapper: BookWithRentalMapper

    @Autowired
    private lateinit var bookMapper: BookMapper

    @Autowired
    private lateinit var rentalMapper: RentalMapper


    companion object {
        @Container
        @JvmStatic
        val mysqlContainer = MySQLContainer<Nothing>(DockerImageName.parse("mysql")).apply {
            withUsername("user")
            withPassword("mysql")
            withDatabaseName("testdb")
            withInitScript("initdb/schema.sql")
        }

        @DynamicPropertySource
        @JvmStatic
        fun setUp(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl)
            registry.add("spring.datasource.username", mysqlContainer::getUsername)
            registry.add("spring.datasource.password", mysqlContainer::getPassword)
        }
    }

    @Test
    fun `InsertしたRecordの内容が取得できる`() {
        // given
        val now = LocalDate.now()
        val bookRecord = BookRecord(
            100,
            "コトリン入門",
            "コトリン太郎",
            now
        )
        val timeNow = LocalDateTime.now()
        val rentalRecord = RentalRecord(
            100,
            1,
            timeNow,
            timeNow
        )
        bookMapper.insert(bookRecord)
        rentalMapper.insert(rentalRecord)

        // when
        val actual = bookWithRentalMapper.select()

        // then
        SoftAssertions().apply {
            assertThat(actual.size).isEqualTo(1)
        }.assertAll()

        val actualOne = actual.get(0)
        SoftAssertions().apply {
            assertThat(actualOne.id).isEqualTo(bookRecord.id)
            assertThat(actualOne.author).isEqualTo(bookRecord.author)
            assertThat(actualOne.title).isEqualTo(bookRecord.title)
            assertThat(actualOne.releaseDate).isEqualTo(bookRecord.releaseDate)
            assertThat(actualOne.userId).isEqualTo(rentalRecord.userId)
            assertThat(actualOne.rentalDateTime).isEqualTo(rentalRecord.rentalDatetime)
            assertThat(actualOne.returnDeadline).isEqualTo(rentalRecord.returnDeadline)
        }.assertAll()
    }
}