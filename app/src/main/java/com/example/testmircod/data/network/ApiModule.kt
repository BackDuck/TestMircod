package com.example.testmircod.data.network

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.testmircod.data.network.requests.general.RequestExceptionWrapper
import com.example.testmircod.data.network.requests.general.Requests
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        private const val API_VERSION = "v2"
        private const val URL = "https://api.foursquare.com/$API_VERSION/"
    }


    @Provides
    @Singleton
    fun provideGeneralRequests(okHttpClient: OkHttpClient, gson: Gson): Requests {
        val halvaRequests = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
                .baseUrl(URL)
                .build()
                .create(Requests::class.java)
        return RequestExceptionWrapper(halvaRequests)
    }

    @Provides
    @Singleton
    fun provideGeneralApi(requests: Requests): Api {
        return ApiImpl(requests)
    }

}