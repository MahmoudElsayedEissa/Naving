package com.example.naving.rx.presentation.ui.request_detail

import com.example.naving.rx.domain.model.CategorySectionDomainModel

sealed interface RequestDetailUiState {
    data object Idle : RequestDetailUiState
    data object Loading : RequestDetailUiState
    data class Success(val categories: List<CategorySectionDomainModel>) : RequestDetailUiState
    data class Error(val message: String) : RequestDetailUiState
    data object Confirmed : RequestDetailUiState
}
