package com.example.yieldmaxcorel.csv

import org.junit.Assert.assertTrue
import org.junit.Test


class CSVReaderKtTest : BaseTest() {
    @Test
    fun cSVReaderSplitsCSVFileIntoRows() {
        assertTrue(data.size == 348)
    }
}