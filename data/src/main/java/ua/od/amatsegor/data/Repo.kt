package ua.od.amatsegor.data

import io.reactivex.Single
import ua.od.amatsegor.data.datasource.IDataSource
import ua.od.amatsegor.data.datasource.IMutableDataSource
import ua.od.amatsegor.data.datasource.api.entity.NetworkUserEntity
import ua.od.amatsegor.data.datasource.mapper.DataUserMapper
import ua.od.amatsegor.data.entity.DataUserEntity

class Repo(val localDataSource: IMutableDataSource, val remoteDataSource: IDataSource) {

    fun getUserRx(): Single<List<DataUserEntity>> {
        return remoteDataSource
            .getUser()
            .flatMap { list -> Single.just(list.map { DataUserMapper.map(it) }) }
    }
}