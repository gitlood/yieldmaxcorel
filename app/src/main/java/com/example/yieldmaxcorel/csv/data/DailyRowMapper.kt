package com.example.yieldmaxcorel.csv.data

fun mapAllRows(data: List<String>): List<DailyRow> {
    return data.map {
        it.mapDailyStringToDailyRow()
    }
}

fun String.mapDailyStringToDailyRow(): DailyRow {
    val formattedRow = substring(1, this.length - 1)
    val rowSpilt = formattedRow.split(",")

    return DailyRow(
        date = rowSpilt[0],
        close = rowSpilt[1].toDouble(),
        volume = rowSpilt[2].replace(",", "").toInt(),
        open = rowSpilt[3].toDouble(),
        high = rowSpilt[4].toDouble(),
        low = rowSpilt[5].toDouble()
    )
}
