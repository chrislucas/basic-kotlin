package com.br.samples.apis.apigithub.repositories

import com.br.samples.apis.apigithub.endpoint.GithubEndpoint
import com.br.samples.apis.http.ObserverRemoteRepository
import com.br.samples.apis.utils.http.RemoteRepository.doAsyncRequest
import com.br.samples.apis.utils.ProvideRetrofitinstance
import com.br.samples.apis.utils.http.WrapperData
import com.br.samples.apis.utils.http.WrapperOnError
import com.br.samples.apis.utils.http.WrapperOnSucess
import kotlinx.coroutines.*
import retrofit2.Response
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

    override fun notify(data: WrapperData) {
        when (data) {
            is WrapperOnSucess<*> -> {
                val unwrap =  (data.wrapSucess.result.getOrNull() as Response<*>).body()
                println(unwrap)
            }
            is WrapperOnError<*> -> {
                val unwrap = data.wrapError.result
                println(unwrap)
            }

            else -> {
                println("Error")
            }
        }
    }
}