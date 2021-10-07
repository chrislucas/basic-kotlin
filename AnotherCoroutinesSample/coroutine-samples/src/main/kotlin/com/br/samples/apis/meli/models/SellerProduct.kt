package com.br.samples.apis.meli.models

import com.br.samples.apis.http.CallbackRemoteRepository
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class SellerProduct(
    @SerializedName("id") val id: String,
    @SerializedName("power_seller_status") val status: String
)

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