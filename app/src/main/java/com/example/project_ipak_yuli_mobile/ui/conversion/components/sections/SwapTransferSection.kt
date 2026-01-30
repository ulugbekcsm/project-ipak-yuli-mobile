package com.example.project_ipak_yuli_mobile.ui.conversion.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_ipak_yuli_mobile.domain.model.transferswap.TransferRole
import com.example.project_ipak_yuli_mobile.ui.conversion.components.buttons.SwapTransferButton
import com.example.project_ipak_yuli_mobile.ui.conversion.components.items.TransferSelectCard

@Composable
fun SwapTransferSection(
    transferRolePair: Pair<TransferRole, TransferRole>,

    isAnimateToBottom: Boolean,
    isAnimateToTop: Boolean,

    onAnimateToBottomDismiss: () -> Unit,
    onAnimateToTopDismiss: () -> Unit,

    onSwapTransfer: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .fillMaxWidth()
            .height(254.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TransferSelectCard(
                title = transferRolePair.first.senderTitle,
                currency = transferRolePair.first.currency,
                animateToBottom = true,
                isAnimateActive = isAnimateToBottom,
                onAnimateDismiss = { onAnimateToBottomDismiss() }
            )

            TransferSelectCard(
                title = transferRolePair.second.receiverTitle,
                currency = transferRolePair.second.currency,
                animateToBottom = false,
                isAnimateActive = isAnimateToTop,
                onAnimateDismiss = { onAnimateToTopDismiss() }
            )
        }

        SwapTransferButton(
            modifier = Modifier.align(Alignment.CenterEnd),
            onClick = { onSwapTransfer() }
        )
    }
}