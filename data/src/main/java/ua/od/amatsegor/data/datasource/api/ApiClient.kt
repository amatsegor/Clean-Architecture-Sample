package ua.od.amatsegor.data.datasource.api

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import ua.od.amatsegor.data.datasource.api.entity.NetworkUserEntity

interface ApiClient {

    @GET("users")
    fun getUsers(): Single<Response<List<NetworkUserEntity>>>
}