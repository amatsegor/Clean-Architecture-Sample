package ua.od.amatsegor.presentation.mapper

import ua.od.amatsegor.domain.entity.DomainEntity
import ua.od.amatsegor.presentation.entity.PresentationEntity

interface PresentationMapper<S : DomainEntity, R : PresentationEntity> {
    fun map(source: S): R
}