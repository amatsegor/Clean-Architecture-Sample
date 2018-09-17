package ua.od.amatsegor.data.datasource

import io.reactivex.Single
import ua.od.amatsegor.data.datasource.api.entity.NetworkUserEntity

interface IDataSource {
    fun getUser(): Single<List<NetworkUserEntity>>
}