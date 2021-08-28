package com.br.samples.apis.meli.repositories

import com.br.samples.apis.http.ObserverRemoteRepository
import com.br.samples.apis.meli.endpoint.MercadoLivreEndpoint
import com.br.samples.apis.utils.ProvideRetrofitinstance
import com.br.samples.apis.utils.http.RemoteRepository.doAsyncRequest
import com.br.samples.apis.utils.http.model.AbstractWrapperResult
import com.br.samples.apis.utils.http.model.getBodyResponse
import retrofit2.converter.gson.GsonConverterFactory

class RemoteMeliRepository : ObserverRemoteRepository {


    private val endpoint = ProvideRetrofitinstance.meliInstanceEndpoint(
        ProvideRetrofitinstance.SITE_MLA, GsonConverterFactory.create()
    ).create(MercadoLivreEndpoint::class.java)

    fun getProducts(productName: String) {
        doAsyncRequest(endpoint.searchProductsByName(productName), this)
    }

    override fun notify(data: AbstractWrapperResult) {
        when (data) {
            is AbstractWrapperResult.Success<*> -> {
                val rs = data.getBodyResponse()
                println(rs)
            }
            else -> {
                println(data)
            }
        }
    }
}