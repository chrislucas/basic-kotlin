package com.br.samples.apigithub

import com.br.samples.apigithub.repositories.RemoteRepositoryGithub
import kotlinx.coroutines.Dispatchers


fun main() {
    val remoteRepositoryGithub = RemoteRepositoryGithub(Dispatchers.Default)
    remoteRepositoryGithub.getRepositories()
}