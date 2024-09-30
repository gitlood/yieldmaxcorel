package com.example.yieldmaxcorel.csv.data

import com.example.yieldmaxcorel.csv.BaseTest
import org.junit.Assert.assertTrue
import org.junit.Test

class DailyRowMapperTest : BaseTest() {

    @Test
    fun mapAllRowsMapsAllDataCorrectly() {
        mapAllRows(data)
        assertTrue(mapAllRows(data).size == 348)
    }
}