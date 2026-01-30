package com.example.project_ipak_yuli_mobile.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.project_ipak_yuli_mobile.data.model.bankingservice.BankingServiceDto
import com.example.project_ipak_yuli_mobile.data.model.usefuloffer.UsefulOfferDto
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCardCover
import com.example.project_ipak_yuli_mobile.data.model.usercard.UserCardCoverDto
import com.example.project_ipak_yuli_mobile.domain.model.usercard.UserCard
import com.example.project_ipak_yuli_mobile.core.utils.getUserCardPattern
import com.example.project_ipak_yuli_mobile.data.model.usercard.UserCardDto
import com.example.project_ipak_yuli_mobile.data.model.userhome.UserHomeDto
import com.example.project_ipak_yuli_mobile.data.model.usertransfer.UserTransferDto
import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingService
import com.example.project_ipak_yuli_mobile.domain.model.card.CardState
import com.example.project_ipak_yuli_mobile.domain.model.usefuloffer.UsefulOffer
import com.example.project_ipak_yuli_mobile.domain.model.userhome.UserHome
import com.example.project_ipak_yuli_mobile.domain.model.usertransfer.UserTransfer
import com.example.project_ipak_yuli_mobile.core.utils.getAmountText
import com.example.project_ipak_yuli_mobile.core.utils.getDateText
import com.example.project_ipak_yuli_mobile.core.utils.getTimeText
import com.example.project_ipak_yuli_mobile.data.model.bankingservice.BankingServiceIconDto
import com.example.project_ipak_yuli_mobile.data.model.bankingservice.BankingServiceLinksDto
import com.example.project_ipak_yuli_mobile.data.model.payment.PaymentDto
import com.example.project_ipak_yuli_mobile.data.model.payment.PaymentIconResourceDto
import com.example.project_ipak_yuli_mobile.data.model.payment.PaymentLinksDto
import com.example.project_ipak_yuli_mobile.data.model.service.ServiceDto
import com.example.project_ipak_yuli_mobile.data.model.service.ServiceIconDto
import com.example.project_ipak_yuli_mobile.data.model.service.ServiceIconLinksDto
import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingServiceIcon
import com.example.project_ipak_yuli_mobile.domain.model.bankingservice.BankingServiceLinks
import com.example.project_ipak_yuli_mobile.domain.model.payment.Payment
import com.example.project_ipak_yuli_mobile.domain.model.payment.PaymentIconResource
import com.example.project_ipak_yuli_mobile.domain.model.payment.PaymentLinks
import com.example.project_ipak_yuli_mobile.domain.model.service.Service
import com.example.project_ipak_yuli_mobile.domain.model.service.ServiceIcon
import com.example.project_ipak_yuli_mobile.domain.model.service.ServiceIconLinks

fun UserCardDto.toDomain(): UserCard {
    return UserCard(
        id = id,
        balance = balance,
        state = state,
        creditLimit = creditLimit,
        pan = pan,
        expire = expire,
        currency = currency,
        isVirtual = isVirtual,
        type = type,
        hasInfo = hasInfo,
        pattern = pattern,
        vendor = vendor,
        isMain = isMain,
        isHidden = isHidden,
        isOwner = isOwner,
        title = title,
        account = account,
        cover = cover.toDomain(),
        canFlip = state == CardState.ACTIVE.display,
        cardPattern = getUserCardPattern(pattern)
    )
}

fun UserCardCoverDto.toDomain(): UserCardCover {
    return UserCardCover(
        cover = cover,
        coverMini = coverMini,
        logoImage = logoImage,
        logoImageMini = logoImageMini
    )
}

fun UserHomeDto.toDomain(): UserHome {
    return UserHome(
        id = id,
        name = name
    )
}

fun BankingServiceDto.toDomain(): BankingService {
    return BankingService(
        id = id,
        code = code,
        name = name,
        icon = icon.toDomain()
    )
}

fun BankingServiceIconDto.toDomain(): BankingServiceIcon {
    return BankingServiceIcon(
        id = id,
        name = name,
        link = link,
        links = links.toDomain()
    )
}

fun BankingServiceLinksDto.toDomain(): BankingServiceLinks {
    return BankingServiceLinks(
        light = light,
        dark = dark
    )
}

fun UsefulOfferDto.toDomain(): UsefulOffer {
    return UsefulOffer(
        id = id,
        title = title,
        image = image,
        link = link,
        showOrder = showOrder,
        state = state,
        lang = lang,
        important = important
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun UserTransferDto.toDomain(): UserTransfer {
    return UserTransfer(
        date = getDateText(date),
        time = getTimeText(date),
        amount = getAmountText(amount),
        currency = currency
    )
}

fun ServiceDto.toDomain(): Service {
    return Service(
        key = key,
        type = type,
        title = title,
        isEnabled = isEnabled,
        isOn = isOn,
        icon = icon.toDomain()
    )
}

fun ServiceIconDto.toDomain(): ServiceIcon {
    return ServiceIcon(
        id = id,
        name = name,
        type = type,
        links = links.toDomain()
    )
}

fun ServiceIconLinksDto.toDomain(): ServiceIconLinks {
    return ServiceIconLinks(
        light = light,
        dark = dark
    )
}

fun PaymentDto.toDomain(): Payment {
    return Payment(
        id = id,
        name = name,
        displayOrder = displayOrder,
        color = color,
        iconName = iconName,
        iconLink = iconLink,
        iconResource = iconResource.toDomain()
    )
}

fun PaymentIconResourceDto.toDomain(): PaymentIconResource {
    return PaymentIconResource(
        id = id,
        name = name,
        type = type,
        links = links.toDomain()
    )
}

fun PaymentLinksDto.toDomain(): PaymentLinks {
    return PaymentLinks(
        light = light,
        dark = dark
    )
}