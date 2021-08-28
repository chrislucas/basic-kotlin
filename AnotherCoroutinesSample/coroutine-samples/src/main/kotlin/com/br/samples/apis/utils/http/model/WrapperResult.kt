package com.br.samples.apis.utils.http.model

import retrofit2.Response

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


fun <T> WrapperOnSucess<T>.getBodyResponse() = (this.wrapSucess.result.getOrNull() as Response<*>).body()