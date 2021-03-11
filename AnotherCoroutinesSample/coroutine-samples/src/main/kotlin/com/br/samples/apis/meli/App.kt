package com.br.samples.apis.meli

import com.br.samples.apis.meli.repositories.RemoteMeliRepository

fun main() {
    val remote = RemoteMeliRepository()
    remote.getProducts("Samsung Galaxy s20")
}