package com.br.samples.apis.http

import retrofit2.Call
import retrofit2.Response

object BuilderResponse {
    @JvmStatic
    fun <T> responseOnSucess(call: Call<T>, response: Response<T>): Pair<Call<T>, Response<T>> =
        call to response

    @JvmStatic
    fun <T> responseOnError(call: Call<T>, throwable: Throwable): Pair<Call<T>, Throwable> =
        call to throwable
}