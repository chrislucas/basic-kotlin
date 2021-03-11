package com.br.samples.apigithub.endpoint

import com.br.samples.apigithub.models.RemoteGithubRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubRepo {
    @GET( "users/{user}/repos")
    fun getRepositories(@Path("user") user: String): Call<List<RemoteGithubRepository>>
}