package com.example.naving.rx.data.mappers

import com.example.naving.rx.data.model.InitializeRequestBody
import com.example.naving.rx.data.model.InitializeRequestInfoBody
import com.example.naving.rx.domain.model.InitializeRequestDomainBody

object InitializeRequestBodyDomainMapper {

    fun mapBodyToRemote(domainModel: InitializeRequestDomainBody): InitializeRequestBody =
        with(domainModel) {
            InitializeRequestBody(
                requestType = requestType,
                requestData = InitializeRequestInfoBody(
                    trancheID = requestData.trancheID,
                    amount = requestData.amount
                )
            )
        }
}
