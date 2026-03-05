package com.example.naving.rx.data.model

data class InitializeRemoteRequestBody(
    val requestType: String,
    val requestData: InitializeRequestInfoBody,
)