package ua.od.amatsegor.domain.mapper

import ua.od.amatsegor.data.entity.DataUserEntity
import ua.od.amatsegor.domain.entity.DomainUserEntity

object DomainUserMapper : DomainMapper<DataUserEntity, DomainUserEntity> {
    override fun map(source: DataUserEntity): DomainUserEntity {
        return DomainUserEntity(source.id, source.name)
    }
}