package com.br.samples.feature.anonsystemapi.bgpstream.models

import com.google.gson.annotations.SerializedName

data class MetaProject(
    @SerializedName("time") val timestamp: Long,
    @SerializedName("type") val type: String,
    @SerializedName("queryParameters") val params: Map<String, Any>
)


data class Project(@SerializedName("project") val name: String, @SerializedName("dataTypes") val dataTypes: DataTypes)


data class DataTypes(@SerializedName("ribs") val ribs: Type, @SerializedName("update") val update: Type)


data class Type(
    @SerializedName("dumpPeriod") val dumpPeriod: Long,
    @SerializedName("dumpDuration") val dumpDuration: Long,
    @SerializedName("oldestDumpTime") val oldestDumpTime: String,
    @SerializedName("latestDumpTime") val latestDumpTime: Long,
)