package com.br.samples.apis.utils.http.model

import retrofit2.Response

sealed class AbstractWrapperResult {

    data class Data<T>(val result: T)

    data class Success<T>(private val mResult: T) : AbstractWrapperResult() {
        val result: Data<Result<T>>
            get() {
                return Data(Result.success(mResult))
            }
    }


    data class Failure(private val mException: Exception) : AbstractWrapperResult() {
        val exception: Data<Result<Throwable>>
            get() = Data(Result.failure(mException))

    }
}

fun <T> AbstractWrapperResult.Success<T>.getBodyResponse() = (this.result.result.getOrNull() as Response<*>).body()

