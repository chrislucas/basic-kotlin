package com.br.sample.randomize

import com.br.sample.helpers.string
import com.br.sample.helpers.toArray


fun main() {
    println((1000 .. 1015 step 3).toArray().string())
}