package com.br.sample.feature.notification.decorator.models

open class BaseNotifierDecorator(private val wrapper: BaseNotifier, list: List<Client>) : BaseNotifier(list) {
    override fun notify(message: String) {
        log()
        wrapper.notify(message)
    }

    private fun log() {
        println("*****************************************************************")
        println("BaseDecorator: ${this.javaClass.name} -  Notifier\n")
        println("*****************************************************************")
    }
}