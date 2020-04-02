package com.example.testmircod.data.storage

import android.content.SharedPreferences
import io.reactivex.Completable
import io.reactivex.Single
import com.example.testmircod.domain.exceptions.auth.NotAuthenticateException
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class DataStorageImpl @Inject constructor() : DataStorage {

    companion object {
        private const val KEY_TOKEN= "KEY_TOKEN"
    }

    @Inject
    @field:Named("userPreferences")
    lateinit var userPreferences: SharedPreferences


    override fun getToken(): Single<String> {
        return Single.fromCallable {
            val token = userPreferences.getString(KEY_TOKEN, null) ?: throw NotAuthenticateException("Token is null")
            "Bearer $token"
        }
    }

    override fun setToken(token: String): Completable {
        return Completable.fromAction {
            userPreferences.edit().putString(KEY_TOKEN, token).apply()
        }
    }

    override fun removeToken(): Completable {
        return Completable.fromAction {
            userPreferences.edit().remove(KEY_TOKEN).apply()
        }
    }




}