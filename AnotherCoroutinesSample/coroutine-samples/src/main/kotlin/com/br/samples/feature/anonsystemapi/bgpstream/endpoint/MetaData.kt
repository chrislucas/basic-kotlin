package com.br.samples.feature.anonsystemapi.bgpstream.endpoint

import com.br.samples.feature.anonsystemapi.bgpstream.models.MetaProject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MetaData {

    @GET("meta/projects/{project}")
    fun asyncRequestProject(@Path("project") project: String): Call<MetaProject>

    @GET("meta/projects/{project}")
    suspend fun requestProject(@Path("project") project: String): Response<MetaProject>
}