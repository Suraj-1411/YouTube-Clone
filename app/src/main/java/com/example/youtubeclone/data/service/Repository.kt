package com.example.youtubeclone.data.service

import com.example.youtubeclone.data.models.User
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject
import kotlin.jvm.Throws
//https://jsonplaceholder.typicode.com/posts
class Repository @Inject constructor(private val remoteService: RemoteService) {

    @Throws(Exception::class)
    suspend fun getData() : User{
        return remoteService.httpClient.get{
            url("https://jsonplaceholder.typicode.com/todos/1")
        }.body()
    }
}