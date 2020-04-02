package com.example.testmircod.data.network.requests

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer

class ExceptionSingleComposer<T>(private val error: ((Throwable) -> Throwable)? = null) : SingleTransformer<T, T> {


    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.onErrorResumeNext {
            Single.error(ExceptionProcessor.preProcessGeneralThrowable(it))
        }.onErrorResumeNext {
            Single.error(error?.invoke(it) ?: it)
        }.onErrorResumeNext {
            Single.error(ExceptionProcessor.postProcessGeneralThrowable(it))
        }
    }
}