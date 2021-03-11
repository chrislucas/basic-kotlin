package com.br.samples.apis.http

import retrofit2.Call
import retrofit2.Response

interface CallbackRemoteRepository<T> {
    fun onSuccess(call: Call<T>, response: Response<T>)
    fun onError(call: Call<T>, t: Throwable)
}