package com.example.naving.rx.data.remote

import com.example.naving.rx.data.model.BaseResponseModel
import com.example.naving.rx.data.model.CategoryDataResponse
import com.example.naving.rx.data.model.InitializeRequestBody
import com.example.naving.rx.data.model.RequestRemoteModel
import com.example.naving.rx.data.remote.APIS.CONSTANTS.MARKET_CATEGORIES_URL
import com.example.naving.rx.data.remote.RequestsURLS.CONFIRM_REQUEST
import com.example.naving.rx.data.remote.RequestsURLS.GET_REQUEST_DETAILS
import com.example.naving.rx.data.remote.RequestsURLS.INITIALIZE_REQUEST
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService{
    @GET(GET_REQUEST_DETAILS)
    fun getRequestDetails(@Path("requestId") requestId: String): Single<BaseResponseModel<RequestRemoteModel>>


    @POST(INITIALIZE_REQUEST)
    fun initializeRequest(@Body body: InitializeRequestBody): Single<BaseResponseModel<RequestRemoteModel>>

    @PATCH(CONFIRM_REQUEST)
    fun confirmRequest(@Path("requestId") requestId: String): Completable

    @GET(MARKET_CATEGORIES_URL)
    fun getMarketCategories(): Single<BaseResponseModel<CategoryDataResponse>>
}