package ru.triptomeet.utils

import java.text.SimpleDateFormat
import java.util.*

fun getMonthNameByNumber(number:Int):String {
    val month = SimpleDateFormat("LLLL", Locale.getDefault())
    val cal = Calendar.getInstance()
    cal.set(Calendar.MONTH, (number-1))
    return (month.format(cal.time)).toString()
}
