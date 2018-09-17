package ua.od.amatsegor.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ua.od.amatsegor.data.Repo
import ua.od.amatsegor.data.datasource.IDataSource
import ua.od.amatsegor.data.datasource.IMutableDataSource
import ua.od.amatsegor.data.datasource.api.ApiClient
import ua.od.amatsegor.data.datasource.api.NetworkDataSource
import ua.od.amatsegor.data.datasource.db.DbDataSource

@Module(includes = [NetworkModule::class])
class RepoModule {
    @Provides
    fun provideRemoteDataSource(apiClient: ApiClient): IDataSource = NetworkDataSource(apiClient)

    @Provides
    fun provideLocalDataSource(context: Context): IMutableDataSource = DbDataSource(context)

    @Provides
    fun provideRepo(localDS: IMutableDataSource, remoteDS: IDataSource): Repo =
        Repo(localDS, remoteDS)
}