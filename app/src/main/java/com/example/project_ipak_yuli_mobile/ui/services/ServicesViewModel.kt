package com.example.project_ipak_yuli_mobile.ui.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.project_ipak_yuli_mobile.domain.usecase.services.GetServicesUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServicesViewModel @Inject constructor(
    private val getServicesUseCase: GetServicesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ServicesUiState())
    val uiState: StateFlow<ServicesUiState> = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<ServicesEvent>()
    val event = _event.asSharedFlow()

    private var loadingCount = 0

    init {
        loadServices()
    }

    private fun loadServices() {
        viewModelScope.launch {

            startLoading()

            getServicesUseCase.invoke().collect { result ->
                result.onSuccess { services ->
                    _uiState.update { it.copy(services = services) }
                    stopLoading()
                }.onFailure { throwable ->
                    stopLoading()
                    _event.emit(ServicesEvent.ShowError(throwable.message ?: "Unknown error"))
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