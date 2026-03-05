package com.example.naving.rx.domain.model

data class SingleRequestDomainModel(
    val administrativeFees: Double,
    val amount: Double,
    val canBeCancelled: Boolean?,
    val icsCount: Int,
    val id: String,
    val referenceNumber: String,
    val requestedAt: Long,
    val requestType: String,
    val stateType: String,
    val totalAmount: Double,
    val trancheID: String,
    val trancheName: String
)