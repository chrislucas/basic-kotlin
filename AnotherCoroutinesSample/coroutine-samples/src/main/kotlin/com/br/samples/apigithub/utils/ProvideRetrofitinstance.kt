package com.br.samples.apigithub.utils

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProvideRetrofitinstance {

    const val BASE_URL = "https://api.github.com/"

    @JvmStatic
    val githubEndpoint: Retrofit = githubInstanceEndpoint(GsonConverterFactory.create())

    @JvmStatic
    fun githubInstanceEndpoint(converter: Converter.Factory) : Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(converter)
            .build()

}