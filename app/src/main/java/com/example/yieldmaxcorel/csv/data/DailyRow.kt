package com.example.yieldmaxcorel.csv.data

data class DailyRow(
    val date: String,
    val close: Double,
    val volume: Int,
    val open: Double,
    val high: Double,
    val low: Double
)
