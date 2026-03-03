package com.example.naving.rx.presentation.ui.request_detail

import androidx.lifecycle.ViewModel
import com.example.naving.rx.domain.usecase.ConfirmRequestUseCase
import com.example.naving.rx.domain.usecase.GetMarketCategoriesUseCase
import com.example.naving.rx.domain.usecase.GetRequestDetailsUseCase
import com.example.naving.rx.schedule.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

@HiltViewModel
class RequestDetailViewModel @Inject constructor(
    private val getRequestDetailsUseCase: GetRequestDetailsUseCase,
    private val confirmRequestUseCase: ConfirmRequestUseCase,
    private val getMarketCategoriesUseCase: GetMarketCategoriesUseCase,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val _uiState = BehaviorSubject.createDefault<RequestDetailUiState>(RequestDetailUiState.Idle)
    val uiState: Observable<RequestDetailUiState> = _uiState.hide()

    private val disposables = CompositeDisposable()


    fun loadMarketCategories(marketSelectedCity: String?, marketSelectedArea: String?) {
        _uiState.onNext(RequestDetailUiState.Loading)

        val disposable = getMarketCategoriesUseCase(marketSelectedCity,marketSelectedArea)
            .observeOn(schedulerProvider.main())
            .subscribe(
                { domainModel ->
                    _uiState.onNext(RequestDetailUiState.Success(domainModel))
                },
                { throwable ->
                    _uiState.onNext(
                        RequestDetailUiState.Error(
                            throwable.message ?: "Unknown error occurred"
                        )
                    )
                }
            )
        disposables.add(disposable)
    }

    fun confirmRequest(requestId: String) {
        _uiState.onNext(RequestDetailUiState.Loading)

        val disposable = confirmRequestUseCase(requestId)
            .observeOn(schedulerProvider.main())
            .subscribe(
                {
                    _uiState.onNext(RequestDetailUiState.Confirmed)
                },
                { throwable ->
                    _uiState.onNext(
                        RequestDetailUiState.Error(
                            throwable.message ?: "Confirmation failed"
                        )
                    )
                }
            )
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
