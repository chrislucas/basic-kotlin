package com.br.samples.apis.apigithub.models

import com.google.gson.annotations.SerializedName

data class OwnerRepository(@SerializedName ("login") val userName: String)
