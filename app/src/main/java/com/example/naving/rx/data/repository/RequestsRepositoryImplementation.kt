package com.example.naving.rx.data.repository

import com.example.naving.rx.data.mappers.CategoryDomainDataMapper
import com.example.naving.rx.data.mappers.InitializeRequestBodyDomainMapper
import com.example.naving.rx.data.mappers.SingleRequestDomainMapper
import com.example.naving.rx.data.remote.APIService
import com.example.naving.rx.domain.model.CategorySectionDomainModel
import com.example.naving.rx.domain.model.InitializeRequestDomainBody
import com.example.naving.rx.domain.model.SingleRequestDomainModel
import com.example.naving.rx.domain.repository.RequestsRepository
import com.example.naving.rx.schedule.SchedulerProvider
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RequestsRepositoryImplementation @Inject constructor(
    private val schedulerProvider: SchedulerProvider,
    private val service: APIService
) : RequestsRepository {

    override fun getRequestDetails(requestId: String): Single<SingleRequestDomainModel> =
        service.getRequestDetails(requestId)
            .map { SingleRequestDomainMapper.mapToDomain(it.data) }
            .subscribeOn(schedulerProvider.io())

    override fun initializeRequest(body: InitializeRequestDomainBody): Single<SingleRequestDomainModel> =
        service.initializeRequest(InitializeRequestBodyDomainMapper.mapBodyToRemote(body))
            .map { SingleRequestDomainMapper.mapToDomain(it.data) }
            .subscribeOn(schedulerProvider.io())

    override fun confirmRequest(requestId: String): Completable =
        service.confirmRequest(requestId)
            .subscribeOn(schedulerProvider.io())

    override fun getMarketCategories(
        marketSelectedCity: String?,
        marketSelectedArea: String?
    ): Single<List<CategorySectionDomainModel>> =
        service.getMarketCategories()
            .map { response ->
                response.data.items.categories.map { categorySection ->
                    CategoryDomainDataMapper.map(categorySection)
                }
            }
            .subscribeOn(schedulerProvider.computation())
}