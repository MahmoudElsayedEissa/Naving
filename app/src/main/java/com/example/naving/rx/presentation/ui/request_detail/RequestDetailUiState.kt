package com.example.naving.rx.presentation.ui.request_detail

import com.example.naving.rx.domain.model.SingleRequestDomainModel

sealed interface RequestDetailUiState {
    data object Idle : RequestDetailUiState
    data object Loading : RequestDetailUiState
    data class Success(val request: SingleRequestDomainModel) : RequestDetailUiState
    data class Error(val message: String) : RequestDetailUiState
    data object Confirmed : RequestDetailUiState
}
