package jp.co.penguin.mybatisdemo.infra.repository.record

import java.time.LocalDate

data class BookRecord(
    var id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null
)
