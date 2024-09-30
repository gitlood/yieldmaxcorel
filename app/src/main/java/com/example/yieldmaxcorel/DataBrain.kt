package com.example.yieldmaxcorel

import com.example.yieldmaxcorel.csv.data.DailyRow
import com.example.yieldmaxcorel.data.ReportData

class DataBrain(private val data: List<DailyRow>) {

    fun generateReportDataForYear(year: String): List<ReportData> {
        return Month.entries.map {
            ReportData(it, getHighestDayOfMonth(it, year), getLowestDayOfMonth(it, year))
        }
    }

    fun getHighestDayOfMonth(month: Month, year: String): String {
        val largestHigh = filterDataByMonth(month, year).maxBy { it.high }
        return largestHigh.date.getDay()
    }

    fun getLowestDayOfMonth(month: Month, year: String): String {
        val lowestLow = filterDataByMonth(month, year).minBy { it.low }
        return lowestLow.date.getDay()
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
    //OCTOBER, NOVEMBER, DECEMBER
}