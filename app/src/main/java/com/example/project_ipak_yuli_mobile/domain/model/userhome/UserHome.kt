package com.example.project_ipak_yuli_mobile.domain.model.userhome

data class UserHome(
    val id: String,
    val name: String,
    val expenses: String = "no",
    val isExpensesVisible: Boolean = false
)