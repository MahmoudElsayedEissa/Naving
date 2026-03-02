package com.example.naving.rx.domain.usecase

import com.example.naving.rx.domain.model.SingleRequestDomainModel
import com.example.naving.rx.domain.repository.RequestsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetRequestDetailsUseCase @Inject constructor(
    private val repository: RequestsRepository
) {
    operator fun invoke(requestId: String): Single<SingleRequestDomainModel> =
        repository.getRequestDetails(requestId)
}
