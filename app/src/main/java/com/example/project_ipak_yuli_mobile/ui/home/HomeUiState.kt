package com.example.project_ipak_yuli_mobile.ui.home

import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingService
import com.example.project_ipak_yuli_mobile.domain.model.usertransfer.UserTransfer
import com.example.project_ipak_yuli_mobile.domain.model.usefuloffer.UsefulOffer
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.domain.model.userhome.UserHome
import com.example.project_ipak_yuli_mobile.core.utils.getCurrentMonthName
import com.example.project_ipak_yuli_mobile.domain.model.balance.Balance
import androidx.compose.ui.text.input.TextFieldValue

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val userHomes: List<UserHome> = emptyList(),
    val bankingServices: List<BankingService> = emptyList(),
    val usefulOffers: List<UsefulOffer> = emptyList(),
    val userTransfers: List<UserTransfer> = emptyList(),
    val userCards: List<UserCard> = emptyList(),

    val searchQuery: String = "",
    val balances: List<Balance> = emptyList(),
    val currentMonth: String = getCurrentMonthName(),

    val phoneNumberPayment: TextFieldValue = TextFieldValue(""),
    val isPhoneNumberPaymentEmpty: Boolean = true,

    val isBalanceVisible: Boolean = false,
    val isBalanceCardSheetVisible: Boolean = false,

    val isHomeScreenRefreshing: Boolean = false
)