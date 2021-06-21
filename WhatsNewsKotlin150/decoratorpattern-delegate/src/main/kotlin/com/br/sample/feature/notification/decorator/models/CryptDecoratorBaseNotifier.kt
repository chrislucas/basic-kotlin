package com.br.sample.feature.notification.decorator.models

open class CryptDecoratorBaseNotifier(private val baseNotifier: BaseNotifier, val crypt: Crypt, list: List<Client>) :
    BaseNotifier(list) {

    override fun notify(message: String) {
        for (client in baseNotifier.clients) {
            println("Client: $client\nMessage: ${crypt.apply(message)}")
        }
        baseNotifier.notify(message)
    }
}