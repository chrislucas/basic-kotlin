package com.br.samples.apigithub.repositories

import com.br.samples.apigithub.endpoint.GithubRepo
import com.br.samples.apigithub.models.http.ObserverRemoteRepository
import com.br.samples.apigithub.repositories.RemoteRepository.doAsyncRequest
import com.br.samples.apigithub.utils.ProvideRetrofitinstance
import com.br.samples.apigithub.utils.http.WrapperData
import com.br.samples.apigithub.utils.http.WrapperOnError
import com.br.samples.apigithub.utils.http.WrapperOnSucess
import kotlinx.coroutines.*
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class RemoteRepositoryGithub(override var coroutineContext: CoroutineContext) : CoroutineScope,
    ObserverRemoteRepository {

    init {
        coroutineContext += SupervisorJob()
    }

    private val endpoint = ProvideRetrofitinstance
        .githubEndpoint
        .create(GithubRepo::class.java)

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