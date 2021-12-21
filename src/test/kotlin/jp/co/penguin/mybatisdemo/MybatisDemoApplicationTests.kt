package jp.co.penguin.mybatisdemo

import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootTest
class MybatisDemoApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun `サンプル`() {
		val hoge = BCryptPasswordEncoder()
		val actual = hoge.encode("admin")
		SoftAssertions().apply {
			assertThat(actual).isEqualTo("\$2a\$10\$.kLvZAQfzNvFFlXzaQmwdeUoq2ypwaN.A/GNy32")
		}.assertAll()
	}
}
