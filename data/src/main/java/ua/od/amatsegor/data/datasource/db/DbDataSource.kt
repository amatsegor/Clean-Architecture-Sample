package ua.od.amatsegor.data.datasource.db

import android.content.Context
import io.reactivex.Single
import ua.od.amatsegor.data.datasource.IMutableDataSource
import ua.od.amatsegor.data.datasource.api.entity.NetworkUserEntity

class DbDataSource(context: Context) : IMutableDataSource {
    override fun getUser(): Single<List<NetworkUserEntity>> {
        return Single.never()
    }
}