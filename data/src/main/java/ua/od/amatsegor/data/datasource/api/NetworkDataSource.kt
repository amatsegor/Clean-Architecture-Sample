package ua.od.amatsegor.data.datasource.api

import io.reactivex.Single
import ua.od.amatsegor.data.datasource.IDataSource
import ua.od.amatsegor.data.datasource.api.entity.NetworkUserEntity

class NetworkDataSource(private val apiClient: ApiClient) : IDataSource {

    override fun getUser(): Single<List<NetworkUserEntity>> {
        return apiClient.getUsers()
            .flatMap {
                val result = it.body()

                return@flatMap if (it.isSuccessful && result != null) {
                    Single.just(result)
                } else {
                    Single.error(Exception(it.errorBody()?.string() ?: "Exception"))
                }
            }
    }
}