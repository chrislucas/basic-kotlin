package sample.com.br.asynctrans

import sample.com.br.asynctrans.action.Transaction

/**
 * Aqui criamos um proxy que encapsula uma transacao e a executa numa Thread separada
 * Podemos ver que a classe que tanto a classe que ENCAPSULA quanto a classe ORIGNAL encapsulada
 * implementam a mesma interface. A classe cliente, que usa o proxy nao tem compreensao desse encapsulamento
 * e isso nao faz diferenca
 * */

class ProxyAsyncTransaction(private val transaction: Transaction) : Transaction {

    override fun execute() {
        val runnable = Runnable {
            transaction.execute()
        }
        Thread(runnable).start()
    }
}