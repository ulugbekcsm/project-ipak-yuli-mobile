package com.example.project_ipak_yuli_mobile.ui.home

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_ipak_yuli_mobile.core.utils.formatPhoneNumber
import com.example.project_ipak_yuli_mobile.domain.usecase.cards.GetUserCardsUseCase
import com.example.project_ipak_yuli_mobile.domain.usecase.home.CalculateBalancesUseCase
import com.example.project_ipak_yuli_mobile.domain.usecase.home.GetBankingServicesUseCase
import com.example.project_ipak_yuli_mobile.domain.usecase.home.GetUsefulOffersUseCase
import com.example.project_ipak_yuli_mobile.domain.usecase.home.GetUserHomesUseCase
import com.example.project_ipak_yuli_mobile.domain.usecase.home.GetUserTransfersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
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
class HomeViewModel @Inject constructor(
    private val getUserHomesUseCase: GetUserHomesUseCase,
    private val getBankingServicesUseCase: GetBankingServicesUseCase,
    private val getUsefulOffersUseCase: GetUsefulOffersUseCase,
    private val getUserTransfersUseCase: GetUserTransfersUseCase,
    private val getUserCardsUseCase: GetUserCardsUseCase,
    private val calculateBalancesUseCase: CalculateBalancesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<HomeEvent>()
    val event: SharedFlow<HomeEvent> = _event.asSharedFlow()

    init {
        refreshHomeScreen()
    }

    fun refreshHomeScreen() {
        viewModelScope.launch {
            startRefreshing()
            _uiState.update { it.copy(isLoading = true) }

            val jobs = listOf(
                async { loadUserHomes() },
                async { loadBankingServices() },
                async { loadUsefulOffers() },
                async { loadUserTransfers() },
                async { loadUserCards() }
            )
            jobs.awaitAll()

            stopRefreshing()
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    private suspend fun loadUserHomes() {
        getUserHomesUseCase().collect { result ->
            result.onSuccess { homes ->
                _uiState.update { it.copy(userHomes = homes) }
            }.onFailure { throwable ->
                _event.emit(HomeEvent.ShowError(throwable.message ?: "Unknown error"))
            }
        }
    }

    private suspend fun loadBankingServices() {
        getBankingServicesUseCase().collect { result ->
            result.onSuccess { services ->
                _uiState.update { it.copy(bankingServices = services) }
            }.onFailure { throwable ->
                _event.emit(HomeEvent.ShowError(throwable.message ?: "Unknown error"))
            }
        }
    }

    private suspend fun loadUsefulOffers() {
        getUsefulOffersUseCase().collect { result ->
            result.onSuccess { offers ->
                _uiState.update { it.copy(usefulOffers = offers) }
            }.onFailure { throwable ->
                _event.emit(HomeEvent.ShowError(throwable.message ?: "Unknown error"))
            }
        }
    }

    private suspend fun loadUserTransfers() {
        getUserTransfersUseCase().collect { result ->
            result.onSuccess { transfers ->
                _uiState.update { it.copy(userTransfers = transfers) }
            }.onFailure { throwable ->
                _event.emit(HomeEvent.ShowError(throwable.message ?: "Unknown error"))
            }
        }
    }

    private suspend fun loadUserCards() {
        getUserCardsUseCase().collect { result ->
            result.onSuccess { cards ->
                _uiState.update { it.copy(userCards = cards) }
            }.onFailure { throwable ->
                _event.emit(HomeEvent.ShowError(throwable.message ?: "Unknown error"))
            }
        }
    }

    private fun startRefreshing() {
        _uiState.update { it.copy(isHomeScreenRefreshing = true) }
    }

    private fun stopRefreshing() {
        _uiState.update { it.copy(isHomeScreenRefreshing = false) }
    }

    fun changeSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun toggleBalanceVisibility() {
        _uiState.update { it.copy(isBalanceVisible = !it.isBalanceVisible) }
    }

    fun showBalanceCardSheet() {
        _uiState.update { it.copy(isBalanceCardSheetVisible = true) }
    }

    fun hideBalanceCardSheet() {
        _uiState.update { it.copy(isBalanceCardSheetVisible = false) }
    }

    fun changePhoneNumberPayment(value: TextFieldValue) {
        val digits = value.text.filter { it.isDigit() }.take(9)
        val formatted = formatPhoneNumber(digits)

        _uiState.update {
            it.copy(
                phoneNumberPayment = TextFieldValue(
                    text = formatted,
                    selection = TextRange(formatted.length)
                )
            )
        }

        updatePaymentActionState()
    }

    private fun updatePaymentActionState() {
        if (_uiState.value.phoneNumberPayment.text.isEmpty()) {
            _uiState.update {
                it.copy(
                    isPhoneNumberPaymentEmpty = true
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    isPhoneNumberPaymentEmpty = false
                )
            }
        }
    }

    fun clearPhoneNumberPayment() {
        _uiState.update {
            it.copy(
                phoneNumberPayment = TextFieldValue(""),
                isPhoneNumberPaymentEmpty = true
            )
        }
    }

    fun toggleExpensesVisibility(id: String) {
        _uiState.update { state ->
            state.copy(
                userHomes = state.userHomes.map { home ->
                    if (home.id == id) home.copy(isExpensesVisible = !home.isExpensesVisible)
                    else home
                }
            )
        }
    }
}