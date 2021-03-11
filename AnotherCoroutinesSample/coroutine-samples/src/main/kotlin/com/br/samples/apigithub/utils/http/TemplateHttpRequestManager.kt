package com.br.samples.apigithub.utils.http

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class WrapperResult<T>(val result: T)

interface WrapperData

class WrapperOnError<T>(val info: T? = null, private val _error: Throwable) : WrapperData {
    val wrapError: WrapperResult<Result<T>>
        get() = WrapperResult(Result.failure(_error))
}

class WrapperOnSucess<T>(private val _result: T) : WrapperData {
    val wrapSucess: WrapperResult<Result<T>>
        get() = WrapperResult(Result.success(_result))
}

abstract class TemplateHttpRequestManager {

    abstract fun executeOnError()

    suspend fun <T> makeRequest(request: () -> T): WrapperData {
        return withContext(Dispatchers.IO) {
            try {
                WrapperOnSucess(request())
            } catch (e: Exception) {
                executeOnError()
                WrapperOnError<Throwable>(_error = e)
            }
        }
    }
}
