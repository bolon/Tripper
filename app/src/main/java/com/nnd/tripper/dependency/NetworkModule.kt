package com.nnd.tripper.dependency

import com.nnd.tripper.model.RESTInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Android dev on 8/4/17.
 */
@Module
class NetworkModule {
    private val BASE_API: String = "http://www.json.org"

    @Provides
    @Singleton
    fun provideCallFactory(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    @Named("rx")
    fun provideRetrofit(client: OkHttpClient, converter: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_API)
                .callFactory(client)
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideREST(@Named("rx") retrofit: Retrofit): RESTInterface {
        return retrofit.create(RESTInterface::class.java)
    }
}