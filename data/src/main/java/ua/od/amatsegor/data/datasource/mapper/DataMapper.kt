package ua.od.amatsegor.data.datasource.mapper

import example.data.datasource.DataSourceEntity
import example.data.entity.DataLayerEntity

interface DataMapper<S: DataSourceEntity, R: DataLayerEntity> {
    fun map(source: S): R
}