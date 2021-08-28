package com.br.samples.apis.utils.http

import com.br.samples.apis.http.CallbackRemoteRepository
import com.br.samples.apis.http.DefaultBehaviorCallback
import com.br.samples.apis.http.ObserverRemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RemoteRepository {

    @JvmStatic
    fun <T> doAsyncRequest(call: Call<T>, observer: ObserverRemoteRepository) =
        doAsyncRequest(call, DefaultBehaviorCallback(observer))

    @JvmStatic
    fun <T> doAsyncRequest(call: Call<T>, callback: CallbackRemoteRepository<T>) {
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

    fun <T> doRequest(call: Call<T>) {
        call.request()
    }
}