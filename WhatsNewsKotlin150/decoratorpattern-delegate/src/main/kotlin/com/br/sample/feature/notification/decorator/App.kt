package com.br.sample.feature.notification.decorator

import com.br.sample.feature.notification.decorator.models.*


private val clients = listOf(Client("chris@gmail.com"))


private fun sampleDecorator() {
    var notifier = BaseNotifier(clients)
    notifier = SMSDecoratorDecorator(notifier, clients)
    notifier = WhatsAppDecorator(notifier, clients)
    notifier = FacebookMessengerDecorator(notifier, clients)
    notifier.notify("Olá Meu Amigo. Sample Decorator")
}

private fun sampleCriptoDecorator() {
    var notifier = BaseNotifier(clients)
    notifier =  FacebookMessengerCryptDecorator(notifier, clients)
    notifier.notify("Olá Meu Amigo. Sample Cripto Decorator")
}


fun main() {
    sampleDecorator()
}