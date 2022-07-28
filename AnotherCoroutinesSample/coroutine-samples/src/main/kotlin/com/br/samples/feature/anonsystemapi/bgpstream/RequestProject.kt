package com.br.samples.feature.anonsystemapi.bgpstream

import com.br.samples.ext.http.CallbackRequest
import com.br.samples.ext.http.IOScope
import com.br.samples.ext.http.doAsyncRequest
import com.br.samples.feature.anonsystemapi.bgpstream.endpoint.MetaData
import com.br.samples.feature.anonsystemapi.bgpstream.endpoint.getEndpoint
import com.br.samples.feature.anonsystemapi.bgpstream.models.MetaProject
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit


/**
 * https://ipdata.co/blog/asn-data-lookup-apis-and-tools/
 * https://api.asrank.caida.org/v2/docs
 * https://ipdata.co/pricing.html
 * https://bgpstream.caida.org/docs/api/broker
 */


private val callbackRequest: CallbackRequest<MetaProject>
    get() = object : CallbackRequest<MetaProject> {

        override fun onSuccess(call: Call<MetaProject>, response: Response<MetaProject>) {
            println(response)
        }

        override fun onError(call: Call<MetaProject>, t: Throwable) {
            println(t)
        }
    }
private val endpoint: MetaData = getEndpoint("https://broker.bgpstream.caida.org/v2/", MetaData::class.java)


private suspend fun requestProject(projectName: String) {
    IOScope.launch {
        val call = endpoint.asyncRequestProject(projectName)
        doAsyncRequest(call, callbackRequest)
    }.join()
}

private suspend fun getProject(projectName: String) {
    IOScope.launch {
        val response: Response<MetaProject> = endpoint.requestProject(projectName)
        println(response)
    }.join()
}

fun main() {
    runBlocking {
        requestProject("routeviews")
        requestProject("ris")

        getProject("routerviews")
        getProject("ris")
    }
}