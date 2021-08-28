package com.br.sample.feature.notification.decorator.models

class SMSDecoratorDecorator(wrapper: BaseNotifier, list: List<Client>) : BaseNotifierDecorator(wrapper, list) {
    override fun notify(message: String) {
        super.notify(message)
        clients.forEach { client ->
            println("Class: ${this.javaClass.name} - Client: $client\nMessage: $message")
        }
        println("*****************************************************************")

    }
}


class SMSDecoratorCriptoDecorator