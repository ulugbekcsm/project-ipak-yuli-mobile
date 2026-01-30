package com.example.project_ipak_yuli_mobile.data.source.remote.api

import com.example.project_ipak_yuli_mobile.data.model.bankingservice.BankingServicesResponseDto
import com.example.project_ipak_yuli_mobile.data.model.payment.PaymentsDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.usertransfer.UserTransfersDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.usefuloffer.UsefulOffersDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.userhome.UserHomesDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.usercard.UserCardsDataResponseDto
import com.example.project_ipak_yuli_mobile.data.model.service.ServicesDataResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface IpakYuliApiService {
    @GET("user/homes")
    suspend fun fetchUserHomes(): Response<UserHomesDataResponseDto>

    @GET("bankingservices")
    suspend fun fetchBankingServices(): Response<BankingServicesResponseDto>

    @GET("usefuloffers")
    suspend fun fetchUsefulOffers(): Response<UsefulOffersDataResponseDto>

    @GET("user/transfers")
    suspend fun fetchUserTransfers(): Response<UserTransfersDataResponseDto>

    @GET("user/cards")
    suspend fun fetchUserCards(): Response<UserCardsDataResponseDto>

    @GET("services")
    suspend fun fetchServices(): Response<ServicesDataResponseDto>

    @GET("payments")
    suspend fun fetchPayments(): Response<PaymentsDataResponseDto>
}