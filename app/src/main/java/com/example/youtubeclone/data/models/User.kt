package com.example.youtubeclone.data.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var userId : Int? =null,
    var title :String ?=null,
    var body :String ?=null,
    var id : Int?=null,
)
