package com.br.samples.apigithub.models

import com.google.gson.annotations.SerializedName

data class OwnerRepo(@SerializedName ("login") val userName: String)
