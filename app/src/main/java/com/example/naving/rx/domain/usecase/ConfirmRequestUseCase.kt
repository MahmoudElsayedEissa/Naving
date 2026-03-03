package com.example.naving.rx.domain.usecase

import com.example.naving.rx.domain.repository.RequestsRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class ConfirmRequestUseCase @Inject constructor(
    private val repository: RequestsRepository
) {
    operator fun invoke(requestId: String): Completable =
        repository.confirmRequest(requestId)
}
