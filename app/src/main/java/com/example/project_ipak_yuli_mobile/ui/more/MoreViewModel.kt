package com.example.project_ipak_yuli_mobile.ui.more

import androidx.lifecycle.ViewModel
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
class MoreViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableStateFlow(MoreUiState())
    val uiState: StateFlow<MoreUiState> = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<MoreEvent>()
    val event: SharedFlow<MoreEvent> = _event.asSharedFlow()

    fun onToggleHideBalanceWithGesture() {
        _uiState.update { it.copy(isHideBalanceWithGestureOn = !it.isHideBalanceWithGestureOn) }
    }

    fun onToggleAppVibration() {
        _uiState.update { it.copy(isAppVibrationOn = !it.isAppVibrationOn) }
    }
}