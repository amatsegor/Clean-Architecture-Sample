package ua.od.amatsegor.data.datasource.api.entity

import example.data.datasource.DataSourceEntity

data class NetworkUserEntity(
    internal val id: String,
    internal val name: String
) : DataSourceEntity