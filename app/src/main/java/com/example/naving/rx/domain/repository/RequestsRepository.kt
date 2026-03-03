package com.example.naving.rx.domain.repository

import com.example.naving.rx.domain.model.CategorySectionDomainModel
import com.example.naving.rx.domain.model.InitializeRequestDomainBody
import com.example.naving.rx.domain.model.SingleRequestDomainModel
import io.reactivex.rxjava3.annotations.SchedulerSupport
import io.reactivex.rxjava3.annotations.SchedulerSupport.IO
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface RequestsRepository {

    @SchedulerSupport(IO)
    fun getRequestDetails(requestId: String): Single<SingleRequestDomainModel>

    @SchedulerSupport(IO)
    fun initializeRequest(body: InitializeRequestDomainBody): Single<SingleRequestDomainModel>

    @SchedulerSupport(IO)
    fun confirmRequest(requestId: String): Completable

    @SchedulerSupport(IO)
    fun getMarketCategories(
        marketSelectedCity: String?,
        marketSelectedArea: String?
    ): Single<List<CategorySectionDomainModel>>
}