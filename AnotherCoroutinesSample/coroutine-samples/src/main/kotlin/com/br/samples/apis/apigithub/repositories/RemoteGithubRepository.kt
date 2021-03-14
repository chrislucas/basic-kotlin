package com.br.samples.apis.apigithub.repositories

import com.br.samples.apis.apigithub.endpoint.GithubEndpoint
import com.br.samples.apis.http.ObserverRemoteRepository
import com.br.samples.apis.utils.ProvideRetrofitinstance
import com.br.samples.apis.utils.http.RemoteRepository.doAsyncRequest
import com.br.samples.apis.utils.http.model.AbstractWrapperResult
import com.br.samples.apis.utils.http.model.getBodyResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class RemoteGithubRepository(override var coroutineContext: CoroutineContext) : CoroutineScope,
    ObserverRemoteRepository {

    init {
        coroutineContext += SupervisorJob()
    }

    private val endpoint = ProvideRetrofitinstance
        .githubEndpoint
        .create(GithubEndpoint::class.java)

    fun getRepositories() {
        doAsyncRequest(endpoint.getRepositories("chrislucas"), this)
    }

    override fun notify(data: AbstractWrapperResult) {
        when (data) {
            is AbstractWrapperResult.Success<*> -> {
                val unwrap = data.getBodyResponse()
                println(unwrap)
            }
            is AbstractWrapperResult.Failure -> {
                val unwrap = data.exception.result.getOrNull()
                println(unwrap)
            }

            else -> {
                println("Error")
            }
        }
    }
}