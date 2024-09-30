package com.example.yieldmaxcorel.csv

import android.content.Context
import androidx.test.core.app.ApplicationProvider

open class BaseTest {

    val context: Context = ApplicationProvider.getApplicationContext()

    val data = readAsCSV("test.csv", context)
}