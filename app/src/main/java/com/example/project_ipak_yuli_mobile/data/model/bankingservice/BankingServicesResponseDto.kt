package com.example.project_ipak_yuli_mobile.data.model.bankingservice

import com.google.gson.annotations.SerializedName

data class BankingServicesResponseDto(
    val data: BankingServicesDataDto
)

data class BankingServicesDataDto(
    @SerializedName("last_update")
    val lastUpdate: Long,
    val services: List<BankingServiceDto>
)