package com.br.samples.apis.utils

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProvideRetrofitinstance {

    private const val BASE_URL_GITHUB_ENDPOINT = "https://api.github.com/"
    private const val BASE_URL_MELI_ENDPOINT = "https://api.mercadolibre.com/sites/"

    const val SITE_MLA = "MLA"

    @JvmStatic
    val githubEndpoint: Retrofit = githubInstanceEndpoint(GsonConverterFactory.create())

    private fun getRetrofitInstance(baseURL: String, converter: Converter.Factory): Retrofit =
        Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(converter)
            .build()

    @JvmStatic
    fun githubInstanceEndpoint(converter: Converter.Factory): Retrofit =
        getRetrofitInstance(BASE_URL_GITHUB_ENDPOINT, converter)


    @JvmStatic
    fun meliInstanceEndpoint(site: String, converter: Converter.Factory): Retrofit =
        getRetrofitInstance(String.format("%s/%s/", BASE_URL_MELI_ENDPOINT, site), converter)

}