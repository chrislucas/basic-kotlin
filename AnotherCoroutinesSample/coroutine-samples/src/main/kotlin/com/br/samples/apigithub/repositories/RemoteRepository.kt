package com.br.samples.apigithub.repositories

import com.br.samples.apigithub.models.http.CallbackRemoteRepository
import com.br.samples.apigithub.models.http.DefaultBehaviorCallback
import com.br.samples.apigithub.models.http.ObserverRemoteRepository
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
                //callback.onSuccess(call, response)
                callback.onError(call, Throwable("Exception Fake"))
            }

            override fun onFailure(call: Call<T>, exception: Throwable) {
                callback.onError(call, Exception(exception))
            }
        }
        call.enqueue(callbackEnqueue)
    }

    fun <T> doRequest(call: Call<T>) {
        call.request()
    }
}