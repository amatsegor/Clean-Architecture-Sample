package ua.od.amatsegor.domain.mapper

import example.data.entity.DataLayerEntity
import ua.od.amatsegor.domain.entity.DomainEntity

interface DomainMapper<S : DataLayerEntity, R : DomainEntity> {
    fun map(source: S): R
}