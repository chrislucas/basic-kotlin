package com.br.samples.apis.meli.endpoint

import com.br.samples.apis.meli.models.ResultSearchProducts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MercadoLivreEndpoint {

    @GET("search")
    fun searchProductsByName(@Query("q") productName: String): Call<ResultSearchProducts>
}