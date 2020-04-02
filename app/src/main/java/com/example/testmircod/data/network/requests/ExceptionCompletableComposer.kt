package com.example.testmircod.data.network.requests

import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.CompletableTransformer

class ExceptionCompletableComposer(private val error: ((Throwable) -> Throwable)? = null) : CompletableTransformer {

    override fun apply(upstream: Completable): CompletableSource {
        return upstream.onErrorResumeNext {
            Completable.error(
                ExceptionProcessor.preProcessGeneralThrowable(
                    it
                )
            )
        }.onErrorResumeNext {
            Completable.error(error?.invoke(it) ?: it)
        }.onErrorResumeNext {
            Completable.error(
                ExceptionProcessor.postProcessGeneralThrowable(
                    it
                )
            )
        }
    }
}