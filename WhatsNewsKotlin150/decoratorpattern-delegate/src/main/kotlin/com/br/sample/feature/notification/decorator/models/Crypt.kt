package com.br.sample.feature.notification.decorator.models

interface Crypt {
    fun apply(message: String): String
}