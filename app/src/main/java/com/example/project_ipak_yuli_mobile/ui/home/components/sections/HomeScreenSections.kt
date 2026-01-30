package com.example.project_ipak_yuli_mobile.ui.home.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingService
import com.example.project_ipak_yuli_mobile.domain.model.userhome.UserHome
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.domain.model.usefuloffer.UsefulOffer
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.domain.model.usertransfer.UserTransfer
import com.example.project_ipak_yuli_mobile.core.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenSections(
    modifier: Modifier,
    userHomes: List<UserHome>,
    bankingServices: List<BankingService>,
    usefulOffers: List<UsefulOffer>,
    userTransfers: List<UserTransfer>,
    userCards: List<UserCard>,
    currentMonth: String,

    isLoading: Boolean,
    isBalanceVisible: Boolean,
    onBalanceVisibilityChange: () -> Unit,
    onBalanceCardSelect: () -> Unit,

    phoneNumberPayment: TextFieldValue,
    isPhoneNumberPaymentEmpty: Boolean,
    onPhoneNumberPaymentChange: (TextFieldValue) -> Unit,
    onPhoneNumberPaymentClear: () -> Unit,

    onExpensesVisibilityChange: (String) -> Unit,
    onNavigateToCards: () -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                HomeBalanceSection(
                    isBalanceVisible = isBalanceVisible,
                    onBalanceVisibilityChange = { onBalanceVisibilityChange() },
                    onBalanceCardSelect = { onBalanceCardSelect() }
                )

                Spacer(modifier = Modifier.height(18.dp))

                QuickActionsSection(
                    onNavigateToCards = { onNavigateToCards() }
                )

                Spacer(modifier = Modifier.height(14.dp))
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = AppColors.AppBackgroundDark,
                        shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp)
                    )
            ) {
                MyHomeSection(
                    userHomes = userHomes,
                    isLoading = isLoading,
                    currentMonth = currentMonth,
                    onExpensesVisibilityChange = { onExpensesVisibilityChange(it) }
                )

                Spacer(modifier = Modifier.height(24.dp))

                BankingServicesSection(
                    bankingServices = bankingServices,
                    isLoading = isLoading
                )

                Spacer(modifier = Modifier.height(24.dp))

                UsefulOffersSection(
                    usefulOffers = usefulOffers,
                    isLoading = isLoading
                )

                Spacer(modifier = Modifier.height(20.dp))

                PhonePaymentSection(
                    phoneNumberPayment = phoneNumberPayment,
                    isPhoneNumberPaymentEmpty = isPhoneNumberPaymentEmpty,
                    onPhoneNumberPaymentChange = { onPhoneNumberPaymentChange(it) },
                    onPhoneNumberPaymentClear = { onPhoneNumberPaymentClear() }
                )

                Spacer(modifier = Modifier.height(10.dp))

                FavouritesSection(
                    isLoading = isLoading
                )

                Spacer(modifier = Modifier.height(20.dp))

                TransactionHistorySection(
                    userTransfers = userTransfers,
                    isLoading = isLoading
                )

                Spacer(modifier = Modifier.height(20.dp))

                MyCardsSection(
                    userCards = userCards,
                    isLoading = isLoading,
                    onClickAllCards = { onNavigateToCards() }
                )

                Spacer(modifier = Modifier.height(20.dp))

                MyAccountsSection()

                Spacer(modifier = Modifier.height(20.dp))

                CustomizeWidgetsSection()

                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}