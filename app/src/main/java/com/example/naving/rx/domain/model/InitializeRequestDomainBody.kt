package com.example.naving.rx.domain.model

data class InitializeRequestDomainBody(
    val requestType: String,
    val requestData: InitializeRequestInfoDomainBody,
)