package com.br.samples.apis.meli.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("title") val name: String,
    @SerializedName("seller") val seller: SellerProduct,
    @SerializedName("price") private val mPrice: Int,
    @SerializedName("available_quantity") private val availableQuantity: Int,
) {
    val price: Double
        get() = mPrice * 1.0
}
