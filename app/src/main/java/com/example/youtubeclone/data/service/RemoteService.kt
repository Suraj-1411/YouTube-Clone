package com.example.youtubeclone.data.service

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class RemoteService {

    val httpClient = HttpClient(Android){
        install(ContentNegotiation){
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(Logging){
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }

    }
}