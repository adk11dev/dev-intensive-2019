package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        else -> throw IllegalStateException("invalid unit")
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {

//    val diffTime = (date.time - this.time) / SECOND
////    val minutes: Array<String> = arrayOf("минуты","минут")
////    val hours: Array<String> = arrayOf("часа","часов")
////
////    return when (diffTime) {
////        in 0..1 -> "только что"
////        in 1..45 -> "несколько секунд назад"
////        in 45..75 -> "минуту назад"
////        in 75..45 * MINUTE -> "${if (diffTime*60>1) hours[0] }минуту назад"
////        else -> "никогда"
////    }
    return "987 сек"
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}