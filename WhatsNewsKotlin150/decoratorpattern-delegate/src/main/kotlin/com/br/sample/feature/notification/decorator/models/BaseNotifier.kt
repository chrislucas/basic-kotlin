package com.br.sample.feature.notification.decorator.models

open class BaseNotifier(val clients: List<Client>) {

    open fun notify(message: String) {
        println("*****************************************************************")
        println("Class: ${this.javaClass.name} -  Notifier\n")
        println("Clients:")
        clients.forEach { client ->
            println("Client: $client\nMessage: $message")
        }
        println("*****************************************************************")

    }
}

