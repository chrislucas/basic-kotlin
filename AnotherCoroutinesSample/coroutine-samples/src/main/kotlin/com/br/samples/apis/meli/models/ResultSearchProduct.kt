package com.br.samples.apis.meli.models

import com.google.gson.annotations.SerializedName

data class MetadataPagingSearch(
    @SerializedName("total") val total: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("primary_results") val primaryResults: Int,
)

data class ResultSearchProducts(
    @SerializedName("site_id") val siteId: String,
    @SerializedName("query") val query: String,
    @SerializedName("paging") val metadataPaging: MetadataPagingSearch,
    @SerializedName("results") val products: List<Product>
)