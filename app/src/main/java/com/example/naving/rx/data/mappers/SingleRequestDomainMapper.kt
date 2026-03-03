package com.example.naving.rx.data.mappers

import com.example.naving.rx.data.model.RequestRemoteModel
import com.example.naving.rx.domain.model.SingleRequestDomainModel

object SingleRequestDomainMapper {

    fun mapToDomain(remoteModel: RequestRemoteModel): SingleRequestDomainModel {
        return with(remoteModel) {
            SingleRequestDomainModel(
                administrativeFees = administrativeFees,
                amount = amount,
                canBeCancelled = canBeCancelled,
                icsCount = icsCount,
                id = id,
                referenceNumber = referenceNumber,
                requestedAt = requestedAt,
                requestType = requestType,
                stateType = stateType,
                totalAmount = totalAmount,
                trancheID = trancheID,
                trancheName = trancheName
            )
        }
    }

}