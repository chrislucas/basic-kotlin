package com.br.samples.apis.meli.models

import com.google.gson.annotations.SerializedName

data class SellerProduct(
    @SerializedName("id") val id: String,
    @SerializedName("power_seller_status") val status: String
)
