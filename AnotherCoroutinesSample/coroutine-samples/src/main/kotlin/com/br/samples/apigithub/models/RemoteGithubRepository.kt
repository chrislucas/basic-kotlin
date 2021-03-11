package com.br.samples.apigithub.models

import com.google.gson.annotations.SerializedName

data class RemoteGithubRepository(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val ownerRepo: OwnerRepo,
    @SerializedName("description") val description: String
)