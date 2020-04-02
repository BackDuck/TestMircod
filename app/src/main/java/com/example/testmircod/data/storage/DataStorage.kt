package com.example.testmircod.data.storage

import io.reactivex.Completable
import io.reactivex.Single

interface DataStorage {

    fun getToken(): Single<String>
    fun setToken(token: String): Completable
    fun removeToken():Completable



}