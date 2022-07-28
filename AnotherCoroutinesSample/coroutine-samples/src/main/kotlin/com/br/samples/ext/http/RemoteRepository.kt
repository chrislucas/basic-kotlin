package com.br.samples.ext.http

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val IOScope = CoroutineScope(Dispatchers.IO)

val IO_SCOPE_SUPERVISOR_JOB = CoroutineScope(Dispatchers.IO + SupervisorJob())

interface CallbackRequest<T> {
    fun onSuccess(call: Call<T>, response: Response<T>)
    fun onError(call: Call<T>, t: Throwable)
}

fun <T> doAsyncRequest(call: Call<T>, callback: CallbackRequest<T>) {
    val callbackEnqueue = object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            callback.onSuccess(call, response)
        }

        override fun onFailure(call: Call<T>, exception: Throwable) {
            callback.onError(call, Throwable(exception))
        }
    }
    call.enqueue(callbackEnqueue)
}