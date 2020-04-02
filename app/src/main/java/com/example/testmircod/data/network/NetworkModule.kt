package com.example.testmircod.data.network

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.example.testmircod.BuildConfig
import com.example.testmircod.utils.Logger
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class NetworkModule {

    companion object {
        private const val TAG_NETWORK = "NetworkRequest"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.IS_USE_LOG) {
            builder.addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Logger.v(TAG_NETWORK, it)
            }).setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson{
        return Gson()
    }


}