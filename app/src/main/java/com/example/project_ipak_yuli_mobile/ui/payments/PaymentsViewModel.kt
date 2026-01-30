package com.example.project_ipak_yuli_mobile.ui.payments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_ipak_yuli_mobile.domain.usecase.payments.GetPaymentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentsViewModel @Inject constructor(
    private val getPaymentsUseCase: GetPaymentsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(PaymentsUiState())
    val uiState: StateFlow<PaymentsUiState> = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<PaymentsEvent>()
    val event: SharedFlow<PaymentsEvent> = _event.asSharedFlow()

    private var loadingCount = 0

    init {
        loadPayments()
    }

    private fun loadPayments() {
        viewModelScope.launch {
            startLoading()

            getPaymentsUseCase.invoke().collect { result ->
                result.onSuccess { payments ->
                    _uiState.update { it.copy(payments = payments) }
                    stopLoading()
                }.onFailure { throwable ->
                    stopLoading()
                    _event.emit(PaymentsEvent.ShowError(throwable.message ?: "Unknown Error"))
                }
            }
        }
    }

    private fun startLoading() {
        loadingCount++
        _uiState.update { it.copy(isLoading = true) }
    }

    private fun stopLoading() {
        loadingCount--
        if (loadingCount <= 0) {
            loadingCount = 0
            _uiState.update { it.copy(isLoading = false) }
        }
    }
}