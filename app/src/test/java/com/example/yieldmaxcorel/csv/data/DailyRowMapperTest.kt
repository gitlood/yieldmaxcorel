package com.example.yieldmaxcorel.csv.data

import org.junit.Assert.assertTrue
import org.junit.Test

class DailyRowMapperTest {
    @Test
    fun mapperMapsCorrectlyWithCommonString() {
        val commonString = "[10/27/2023,20.10,155633,20.41,20.41,19.90]"
        val result = commonString.mapDailyStringToDailyRow()
        assertTrue(
            result.date == "10/27/2023" &&
                    result.close == 20.10 &&
                    result.volume == 155633 &&
                    result.open == 20.41 &&
                    result.high == 20.41 &&
                    result.low == 19.90
        )
    }
}