package com.example.testmircod.utils

import java.text.SimpleDateFormat
import java.util.*

//89677798787
fun formatPhone(phone: String): String? {
    val correct = phone.replace(Regex("\\D"), "")
    return if (correct.length == 11) {
        correct.takeLast(10)
    } else {
        null
    }
}

//9200 000000
fun formatPassport(passport: String): String? {
    val correct = passport.replace(Regex("\\D"), "")
    return if (correct.length == 10) {
        correct.takeLast(10)
    } else {
        null
    }
}

fun Date.toCalendar(): Calendar {
    val c = Calendar.getInstance()
    c.time = this
    return c
}

fun Date.toStringRFC3339DayMonthYear(): String {
    val PERIOD_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    val RESPONSE_FORMAT = "dd MMMM yyyy"
    val format = SimpleDateFormat(RESPONSE_FORMAT, Locale("ru"))
    return format.format(this)
}

fun Calendar.toStringRFC3339(): String {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale("ru"))
    return format.format(this.time)
}

fun Date.toStringWithWeekDay(): String {
    val format = "dd MMMM"

    return try {
        val cal = Calendar.getInstance()
        cal.time = this

        var weekDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
        weekDay = weekDay[0].toUpperCase() + weekDay.substring(1)

        val timeFormat = SimpleDateFormat(format, Locale("ru"))
        return "$weekDay, ${timeFormat.format(this)}"
    } catch (e: Exception) {
        "N/A"
    }
}

fun Calendar.resetTime(): Calendar {
    this.set(Calendar.HOUR_OF_DAY, 0)
    this.set(Calendar.MINUTE, 0)
    this.set(Calendar.SECOND, 0)
    this.set(Calendar.MILLISECOND, 0)

    return this
}

fun <A, B> Map<A, B>.getIfExist(key: A, defaultValue: B? = null): B? {
    return if (this.containsKey(key)) {
        this[key] ?: defaultValue
    } else {
        defaultValue
    }
}

fun Double.toRegularSum(): String {
    return String.format("%.2f руб", this)
}



