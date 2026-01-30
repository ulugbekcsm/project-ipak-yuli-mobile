package com.example.project_ipak_yuli_mobile.ui.conversion

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.example.project_ipak_yuli_mobile.core.utils.formatNumberWithSpaces
import com.example.project_ipak_yuli_mobile.domain.model.transferswap.TransferRole
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ConversionViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableStateFlow(ConversionUiState())
    val uiState: StateFlow<ConversionUiState> = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<ConversionEvent>()
    val event: SharedFlow<ConversionEvent> = _event.asSharedFlow()

    fun onTransferAmountChanged(value: TextFieldValue) {
        val digits = value.text.filter { it.isDigit() }.take(12)
        val formatted = formatNumberWithSpaces(digits)

        _uiState.update {
            it.copy(
                transferAmount = TextFieldValue(
                    text = formatted,
                    selection = TextRange(formatted.length),
                )
            )
        }

        updateTransferAmountEmpty()
    }

    private fun updateTransferAmountEmpty() {
        if (_uiState.value.transferAmount.text.isEmpty()) {
            _uiState.update { it.copy(isTransferAmountEmpty = true) }
        } else {
            _uiState.update { it.copy(isTransferAmountEmpty = false) }
        }
    }

    fun onTransferAmountCleared() {
        _uiState.update {
            it.copy(
                transferAmount = TextFieldValue(""),
                isTransferAmountEmpty = true
            )
        }
    }

    fun onSwapTransferActive() {
        if (_uiState.value.isTransferFromUZS) {
            _uiState.update { state ->
                state.copy(
                    isTransferFromUZS = false,
                    transferRolePair = Pair(
                        first = TransferRole.FROM_UZS_TO_USD,
                        second = TransferRole.FROM_USD_TO_UZS
                    ),
                    isAnimateToBottom = true,
                    isAnimateToTop = true
                )
            }
        } else {
            _uiState.update { state ->
                state.copy(
                    isTransferFromUZS = true,
                    transferRolePair = Pair(
                        first = TransferRole.FROM_USD_TO_UZS,
                        second = TransferRole.FROM_UZS_TO_USD
                    ),
                    isAnimateToBottom = true,
                    isAnimateToTop = true
                )
            }
        }
    }

    fun onAnimateToBottomDismissed() {
        _uiState.update { it.copy(isAnimateToBottom = false) }
    }

    fun onAnimateToTopDismissed() {
        _uiState.update { it.copy(isAnimateToTop = false) }
    }
}