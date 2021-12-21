package jp.co.penguin.mybatisdemo.infra.repository

import jp.co.penguin.mybatisdemo.domain.model.Rental
import jp.co.penguin.mybatisdemo.domain.repository.RentalRepository
import jp.co.penguin.mybatisdemo.infra.repository.mapper.RentalMapper
import jp.co.penguin.mybatisdemo.infra.repository.record.RentalRecord
import org.springframework.stereotype.Repository

@Repository
@Suppress("SpringJavaInjectionPointsAutowiringInspection")
class RentalRepositoryImpl(
    private val rentalMapper: RentalMapper
) : RentalRepository {

    override fun startRental(rental: Rental) {
        rentalMapper.insert(RentalRecord.createByModel(rental))
    }
}