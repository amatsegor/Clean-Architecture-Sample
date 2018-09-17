package ua.od.amatsegor.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ua.od.amatsegor.data.datasource.api.ApiClient
import javax.inject.Named

@Module
class NetworkModule(private val baseUrl: String) {

    @Provides
    fun provideOkhttpCache(context: Context): Cache = Cache(context.cacheDir, CACHE_SIZE)

    @Provides
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    @Provides
    fun provideRxJavaAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    fun providesGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient,
                        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                        gsonConverterFactory: GsonConverterFactory): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Provides
    @Named("ui")
    fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named("io")
    fun provideIoScheduler(): Scheduler = Schedulers.io()

    companion object {
        const val CACHE_SIZE = 5L * 1024 * 1024
    }

}