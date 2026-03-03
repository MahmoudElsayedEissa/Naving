package com.example.naving.rx.domain.usecase

import com.example.naving.rx.domain.model.CategorySectionDomainModel
import com.example.naving.rx.domain.repository.RequestsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetMarketCategoriesUseCase @Inject constructor(
    private val repository: RequestsRepository
) {
    operator fun invoke(
        marketSelectedCity: String?,
        marketSelectedArea: String?
    ): Single<List<CategorySectionDomainModel>> =
        repository.getMarketCategories(marketSelectedCity, marketSelectedArea)
}