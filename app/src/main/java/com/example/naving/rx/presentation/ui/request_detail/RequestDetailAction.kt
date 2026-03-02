package com.example.naving.rx.presentation.ui.request_detail

sealed interface RequestDetailAction {
    data class LoadDetails(val requestId: String) : RequestDetailAction
    data class ConfirmRequest(val requestId: String) : RequestDetailAction
    data object Retry : RequestDetailAction
}
