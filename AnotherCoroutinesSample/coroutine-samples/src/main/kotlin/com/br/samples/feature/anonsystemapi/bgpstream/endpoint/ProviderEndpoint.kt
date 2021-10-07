package com.br.samples.feature.anonsystemapi.bgpstream.endpoint

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun <T> getEndpoint(baseURL: String, contract: Class<T>): T =
    getEndpoint(baseURL, contract, GsonConverterFactory.create())


fun <T> getEndpoint(baseURL: String, service: Class<T>, converter: Converter.Factory): T =
    Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(converter)
        .build()
        .create(service)