package com.br.samples.apis.apigithub

import com.br.samples.apis.apigithub.repositories.RemoteGithubRepository
import kotlinx.coroutines.Dispatchers


fun main() {
    val remoteRepositoryGithub = RemoteGithubRepository(Dispatchers.Default)
    remoteRepositoryGithub.getRepositories()
}