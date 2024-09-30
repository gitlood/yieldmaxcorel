package com.example.yieldmaxcorel.csv

import android.content.Context
import java.io.File
import java.io.IOException
import java.io.InputStreamReader

@Throws(IOException::class)
fun readAsCSV(fileName: String, context: Context): List<String> {
    val file = InputStreamReader(context.assets.open(fileName))
    val lines = file.readLines() as MutableList
    lines.removeAt(0)
    return lines
}