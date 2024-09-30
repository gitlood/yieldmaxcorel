package com.example.yieldmaxcorel

import com.example.yieldmaxcorel.csv.BaseTest
import com.example.yieldmaxcorel.csv.data.mapAllRows
import org.junit.Assert.assertTrue
import org.junit.Test

class DataBrainTest:BaseTest() {

    private val dataBrain = DataBrain(mapAllRows(data))

    @Test
    fun filterDataByMonthFiltersCorrectlyForOnlyYear() {
        val filteredData = dataBrain.filterDataByMonth(year = "2024")
        assertTrue(filteredData.size == 187)
    }

    @Test
    fun filterDataByMonthFiltersCorrectlyForInvalidYear() {
        val filteredData = dataBrain.filterDataByMonth(month = Month.FEBRUARY, year = "3026")
        assertTrue(filteredData.isEmpty())
    }

    @Test
    fun getHighestDayOfMonthGetsTheDayForTheHighOfMonth() {
        val filteredData = dataBrain.filterDataByMonth(year = "")
        assertTrue(filteredData.isEmpty())
    }

    @Test
    fun filterDataByMonthDoesNotFilterIfYearIsBlank() {
        val filteredData = dataBrain.filterDataByMonth(year = "")
        assertTrue(filteredData.isEmpty())
    }

    @Test
    fun getHighestDayOfMonthGetsDayOfHighForAug() {
        val highestDay = dataBrain.getHighestDayOfMonth(month = Month.AUGUST, year = "2024")
        assertTrue(highestDay == "01")
    }

    @Test
    fun getHighestDayOfMonthGetsDayOfHighForFeb() {
        val highestDay = dataBrain.getHighestDayOfMonth(month = Month.FEBRUARY, year = "2024")
        assertTrue(highestDay == "23")
    }

    @Test
    fun getLowestDayOfMonthGetsDayOfHighForAug() {
        val lowestDay = dataBrain.getLowestDayOfMonth(month = Month.AUGUST, year = "2024")
        assertTrue(lowestDay == "05")
    }

    @Test
    fun getLowestDayOfMonthGetsDayOfHighForFeb() {
        val lowestDay = dataBrain.getLowestDayOfMonth(month = Month.FEBRUARY, year = "2024")
        assertTrue(lowestDay == "21")
    }
}