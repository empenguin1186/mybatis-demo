package jp.co.penguin.mybatisdemo.infra.repository.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DataSourceConfig {
    @Bean
    fun datasource(properties: DataSourceProperties): DataSource {
        return properties
            .initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }
}