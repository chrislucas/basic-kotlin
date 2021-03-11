package com.br.samples.apis.apigithub.models

import com.google.gson.annotations.SerializedName

data class GithubRepository(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val ownerRepository: OwnerRepository,
    @SerializedName("description") val description: String
)