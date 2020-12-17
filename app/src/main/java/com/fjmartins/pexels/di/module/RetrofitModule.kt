package com.fjmartins.pexels.di.module

import com.fjmartins.pexels.network.PexelApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            addInterceptor {chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", PexelApi.KEY).build()

                chain.proceed(newRequest)
            }
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient.Builder) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(PexelApi.URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun providePexelApi(retrofit: Retrofit) : PexelApi {
        return retrofit.create(PexelApi::class.java)
    }
}