package ua.od.amatsegor.presentation.mapper

import ua.od.amatsegor.domain.entity.DomainUserEntity
import ua.od.amatsegor.presentation.entity.PresentationUserEntity

object PresentationUserMapper : PresentationMapper<DomainUserEntity, PresentationUserEntity> {
    override fun map(source: DomainUserEntity): PresentationUserEntity {
        return PresentationUserEntity(source.id, source.name)
    }
}