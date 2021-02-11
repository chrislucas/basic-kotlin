package br.com.sample

import kotlinx.coroutines.Job

fun Job.log(): String {
    return this.run {
        "Is cancelled ? $isCancelled, Is Active ? $isActive, key: ${this.key}, Job: $this"
    }
}