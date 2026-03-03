package com.example.naving.rx.data.model

data class BaseResponseModel<T>(val status: Int?, val message: String, val data: T)