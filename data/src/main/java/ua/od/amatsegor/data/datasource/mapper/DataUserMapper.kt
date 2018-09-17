package ua.od.amatsegor.data.datasource.mapper

import ua.od.amatsegor.data.datasource.api.entity.NetworkUserEntity
import ua.od.amatsegor.data.entity.DataUserEntity

object DataUserMapper : DataMapper<NetworkUserEntity, DataUserEntity> {
    override fun map(source: NetworkUserEntity): DataUserEntity {
        return DataUserEntity(source.id, source.name)
    }
}