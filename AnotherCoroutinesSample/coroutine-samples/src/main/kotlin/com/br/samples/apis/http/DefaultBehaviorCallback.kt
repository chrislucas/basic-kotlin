package com.br.samples.apis.http

import com.br.samples.apis.utils.http.DefaultHttpRequestManager
import com.br.samples.apis.utils.http.model.AbstractWrapperResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response


interface ObserverRemoteRepository {
    fun notify(data: AbstractWrapperResult)
}

class DefaultBehaviorCallback<T>(private val observer: ObserverRemoteRepository) : CallbackRemoteRepository<T> {
    override fun onSuccess(call: Call<T>, response: Response<T>) {
        CoroutineScope(Dispatchers.IO).launch {
            observer.notify(DefaultHttpRequestManager().makeRequest { response })
        }
    }

    override fun onError(call: Call<T>, throwable: Throwable) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = DefaultHttpRequestManager().makeRequest { throw Exception(throwable) }
            observer.notify(response)
        }
    }
}