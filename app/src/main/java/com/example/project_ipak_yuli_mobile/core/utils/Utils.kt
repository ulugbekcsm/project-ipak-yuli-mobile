package com.example.project_ipak_yuli_mobile.core.utils

import android.os.Build
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import androidx.annotation.RequiresApi
import com.example.project_ipak_yuli_mobile.domain.model.card.CardPattern
import com.example.project_ipak_yuli_mobile.domain.model.card.CardVendor
import java.util.Locale
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import kotlin.text.iterator

fun getUserCardPattern(pattern: String) : CardPattern {
    return CardPattern.entries.first { it.value == pattern }
}

fun getVendorDisplay(vendor: String): String {
    return CardVendor.entries
        .firstOrNull { it.value == vendor }
        ?.display
        ?: vendor
}

fun fixBalanceSpaced(amount: BigDecimal): String {
    val number = amount.toBigInteger().toLong()
    return "%,d".format(number).replace(",", " ")
}

fun fixPanSpaced(text: String) : String {
    var newText = ""
    var counter = 0
    for (i in text) {
        if (counter == 4) {
            newText += " "
            counter = 0
        }
        newText += i
        counter++
    }
    return newText
}

fun fixPanSpacedLast(text: String) : String {
    val newText = text.substring(8, text.length)
    val middleIndex = newText.length / 2
    return newText.take(middleIndex) + " " + newText.substring(middleIndex)
}

fun fixExpireDataChange(text: String): String {
    return if (text.length >= 4) {
        "${text.substring(2, 4)} / ${text.take(2)}"
    } else {
        "  /  "
    }
}

fun formatPhoneNumber(text: String): String {
    val digits = text.filter { it.isDigit() }.take(9)

    val result = StringBuilder()

    for (i in digits.indices) {
        result.append(digits[i])

        if (i == 1 || i == 4 || i == 6) {
            result.append(' ')
        }
    }

    return result.toString().trim()
}

fun formatNumberWithSpaces(number: String): String {
    val reversed = number.reversed()
    val result = StringBuilder()

    for (i in reversed.indices) {
        result.append(reversed[i])
        if ((i + 1) % 3 == 0 && i != reversed.lastIndex) {
            result.append(' ')
        }
    }

    return result.reverse().toString()
}

@RequiresApi(Build.VERSION_CODES.O)
fun getTimeText(date: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val localDateTime = LocalDateTime.parse(date, formatter)

    val hour = localDateTime.hour
    val minute = localDateTime.minute

    return "%02d:%02d".format(hour, minute)
}

@RequiresApi(Build.VERSION_CODES.O)
fun getDateText(date: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val dateTime = LocalDateTime.parse(date, formatter)

    val date = dateTime.toLocalDate()

    val today = LocalDate.now()
    val yesterday = today.minusDays(1)

    return when (date) {
        today -> "Today"
        yesterday -> "Yesterday"
        else -> dateTime.format(DateTimeFormatter.ofPattern("d MMMM"))
    }
}

fun getAmountText(amount: String): String {
    val number = amount.toLongOrNull() ?: 0L

    val major = number / 100
    val minor = number % 100

    return "%,d.%02d".format(major, minor).replace(',', ' ')
}


fun getCurrentMonthName(): String {
    val calendar = Calendar.getInstance()
    return SimpleDateFormat("MMMM", Locale.ENGLISH).format(calendar.time).lowercase()
}