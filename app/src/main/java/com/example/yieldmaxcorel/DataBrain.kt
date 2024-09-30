package com.example.yieldmaxcorel

import com.example.yieldmaxcorel.csv.data.DailyRow
import com.example.yieldmaxcorel.data.ReportData

class DataBrain(private val data: List<DailyRow>) {

    fun generateReportDataForYear(year: String): List<ReportData> {
        val dailyReportData = mutableListOf<ReportData>()
        Month.entries.forEach {
            getHighestDayOfMonth(it, year)?.let { high ->
                getLowestDayOfMonth(it, year)?.let { low ->
                    dailyReportData.add(ReportData(it, high, low))
                }
            }
        }
        return dailyReportData
    }

    fun getHighestDayOfMonth(month: Month, year: String): String? {
        val monthlyData = filterDataByMonth(month, year)
        return if (monthlyData.isEmpty()) {
            null
        } else
            monthlyData.maxBy { it.high }.date.getDay()
    }

    fun getLowestDayOfMonth(month: Month, year: String): String? {
        val monthlyData = filterDataByMonth(month, year)
        return if (monthlyData.isEmpty()) {
            null
        } else {
            monthlyData.minBy { it.low }.date.getDay()
        }
    }

    fun filterDataByMonth(month: Month? = null, year: String): List<DailyRow> {
        return if (year.length != 4) {
            emptyList()
        } else {
            data.filter {
                when {
                    month != null -> {
                        it.date.getYear() == year && it.date.getMonth() == (month.ordinal + 1).toString()
                    }

                    year.isNotBlank() -> {
                        it.date.getYear() == year
                    }

                    else -> {
                        true
                    }
                }
            }
        }
    }

    private fun String.getYear(): String {
        return substringAfterLast("/")
    }

    private fun String.getMonth(): String {
        val month = substringBefore("/")
        return month
    }

    private fun String.getDay(): String {
        val day = substringAfter("/").substringBeforeLast("/")
        return day
    }
}

enum class Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
    JULY, AUGUST, SEPTEMBER,
    OCTOBER, NOVEMBER, DECEMBER
}