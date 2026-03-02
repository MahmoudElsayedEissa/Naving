package com.example.naving.rx.data.remote

import com.example.naving.rx.data.remote.APIS.CONSTANTS.API
import com.example.naving.rx.data.remote.APIS.CONSTANTS.REAL_ESTATE_PATH
import com.example.naving.rx.data.remote.APIS.CONSTANTS.V1

object RequestsURLS {
    const val GET_REQUESTS = "$API/$V1/$REAL_ESTATE_PATH/requests"
    const val CONFIRM_REQUEST = "$API/$V1/$REAL_ESTATE_PATH/requests/{requestId}/confirm"
    const val GET_REQUEST_DETAILS = "$API/$V1/$REAL_ESTATE_PATH/requests/{requestId}"

    const val INITIALIZE_REQUEST = "$API/$V1/$REAL_ESTATE_PATH/requests"
}