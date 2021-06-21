package com.br.sample.feature.notification.decorator.models

class Rsa: Crypt {
    override fun apply(message: String): String {
        return ""
    }
}

class AES: Crypt {
    override fun apply(message: String): String {
        return ""
    }
}