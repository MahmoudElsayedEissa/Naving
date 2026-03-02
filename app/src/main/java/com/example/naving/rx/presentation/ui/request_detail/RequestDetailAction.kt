package com.example.naving.rx.presentation.ui.request_detail

data class RequestDetailAction(
    val loadDetails: (String?, String?) -> Unit,
    val confirmRequest: (String) -> Unit,
    val retry: () -> Unit
)
