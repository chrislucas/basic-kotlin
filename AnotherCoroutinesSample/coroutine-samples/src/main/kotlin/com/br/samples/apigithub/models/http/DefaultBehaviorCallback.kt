package com.br.samples.apigithub.models.http

import com.br.samples.apigithub.utils.http.DefaultHttpRequestManager
import com.br.samples.apigithub.utils.http.WrapperData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception


interface ObserverRemoteRepository {
    fun notify(data: WrapperData)
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