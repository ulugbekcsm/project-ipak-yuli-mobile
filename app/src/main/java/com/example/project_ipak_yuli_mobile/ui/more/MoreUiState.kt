package com.example.project_ipak_yuli_mobile.ui.more

data class MoreUiState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val isHideBalanceWithGestureOn: Boolean = true,
    val isAppVibrationOn: Boolean = true
)