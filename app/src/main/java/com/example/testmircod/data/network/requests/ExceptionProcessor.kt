package com.example.testmircod.data.network.requests

import com.example.testmircod.domain.exceptions.NotInternetConnectionException
import java.io.IOException

object ExceptionProcessor {


    fun preProcessGeneralThrowable(t: Throwable): Throwable {
        return when (t) {
            is IOException -> NotInternetConnectionException(t)
            else -> t
        }
    }

    fun postProcessGeneralThrowable(t: Throwable): Throwable {
        return t
   /*     if (t !is DomainException) {
            if (t is HttpException) {
                val error = t.response().errorBody()?.string()
                if (!error.isNullOrBlank()) {
                    val innerError = Gson().fromJson<InnerError>(error, InnerError::class.java)
                    when (innerError.innerCode) {
                        BankException.innerCode -> return BankException()
                        CardFetchingWentWrong.innerCode -> return CardFetchingWentWrong()
                        OpenApiException.innerCode -> return OpenApiException()
                        InvalidPasswordException.innerCode -> return InvalidPasswordException()
                        HasNoCardException.innerCode -> return HasNoCardException()
                        ParentNotExistException.innerCode -> return ParentNotExistException()
                        SmsCodeIsIncorrectException.innerCode -> return SmsCodeIsIncorrectException()
                        ChildNotExistException.innerCode -> return ChildNotExistException()
                        ExcessCodeAttemptsException.innerCode -> return ExcessCodeAttemptsException(innerError.data.seconds)
                        WrongCodeException.innerCode -> return WrongCodeException()
                    }

                }
                if (t.code() in 500..599) {
                    return ServerException(t)
                }
            }
            return UnexpectedException(t)
        } else {
            return t
        }*/
    }
}