package com.example.testmircod.domain.exceptions

import java.lang.Exception

class NotInternetConnectionException : Exception {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}