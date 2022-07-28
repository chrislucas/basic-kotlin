package com.br.sample.deserializesubtype

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeInfo.As
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id
import com.fasterxml.jackson.annotation.JsonTypeName


/*
    https://andrewtarry.com/posts/deserialising-an-interface-with-jackson/
    https://attacomsian.com/blog/jackson-read-json-file
 */


/*
    Jackson Annotations - @JsonTypeInfo
    https://www.tutorialspoint.com/jackson_annotations/jackson_annotations_jsontypeinfo.htm

    Jackson Annotations - @JsonSubTypes
    https://www.tutorialspoint.com/jackson_annotations/jackson_annotations_jsonsubtypes.htm

    Estudar os parametros de JsonTypeInfo
    https://www.logicbig.com/tutorials/misc/jackson/json-type-info-with-logical-type-name.html
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = Id.NONE, include = As.PROPERTY)
@JsonSubTypes(
    JsonSubTypes.Type(value = RSA::class, name = "rsa"),
    JsonSubTypes.Type(value = MD5::class, name = "md5")
)
interface Crypto {
    fun apply(): String
}

@JsonTypeName("rsa")
data class RSA(@JsonProperty(value = "data") val data: String) : Crypto {
    override fun apply(): String {
        return data
    }
}

@JsonTypeName("md5")
data class MD5(@JsonProperty(value = "data") val data: String, @JsonProperty(value = "key") val key: String) : Crypto {
    override fun apply(): String {
        return data
    }
}


fun main() {

}


