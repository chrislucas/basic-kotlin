package com.br.samples.apis.apigithub.endpoint

import com.br.samples.apis.apigithub.models.GithubRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubEndpoint {
    @GET( "users/{user}/repos")
    fun getRepositories(@Path("user") user: String): Call<List<GithubRepository>>
}