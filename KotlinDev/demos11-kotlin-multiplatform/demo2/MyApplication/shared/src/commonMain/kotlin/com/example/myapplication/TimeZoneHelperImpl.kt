package com.example.myapplication

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class TimeZoneHelperImpl : TimeZoneHelper {

    override fun getTimeZoneStrings(): List<String> {
        return TimeZone.availableZoneIds.sorted()
    }

    override fun currentTime(): String {
        val now = Clock.System.now()
        val dateTime = now.toLocalDateTime(TimeZone.currentSystemDefault())
        return formatDateTime(dateTime)
    }

    override fun currentTimeZone(): String {
        val currentTimeZone = TimeZone.currentSystemDefault()
        return currentTimeZone.toString()
    }

    override fun hoursFromTimeZone(otherTimeZoneId: String): Double {
        val currentTimeZone = TimeZone.currentSystemDefault()
        val currentUTCNow = Clock.System.now()
        val otherTimeZone = TimeZone.of(otherTimeZoneId)

        val currentDateTime = currentUTCNow.toLocalDateTime(currentTimeZone)
        val currentOtherDateTime = currentUTCNow.toLocalDateTime(otherTimeZone)
        return abs((currentDateTime.hour - currentOtherDateTime.hour) * 1.0)
    }

    override fun getTime(timezoneId: String): String {
        val timezone = TimeZone.of(timezoneId)
        val now = Clock.System.now()
        val dateTime = now.toLocalDateTime(timezone)
        return formatDateTime(dateTime)
    }

    override fun getDate(timezoneId: String): String {
        val timezone = TimeZone.of(timezoneId)
        val now = Clock.System.now()
        val dateTime = now.toLocalDateTime(timezone)

        return "${dateTime.dayOfWeek.name.lowercase().replaceFirstChar { it.uppercase() }}, " +
               "${dateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${dateTime.date.dayOfMonth}"
    }

    override fun search(startHour: Int, endHour: Int, timezoneStrings: List<String>): List<Int> {

        val goodHours = mutableListOf<Int>()
        val timeRange = IntRange(max(0, startHour), min(23, endHour))
        val currentTimeZone = TimeZone.currentSystemDefault()

        for (hour in timeRange) {
            var isGoodHour = false
            for (zone in timezoneStrings) {
                val timezone = TimeZone.of(zone)
                if (timezone == currentTimeZone) {
                    continue
                }
                if (!isValid(timeRange, hour, currentTimeZone, timezone)) {
                    isGoodHour = false
                    break
                } else {
                    isGoodHour = true
                }
            }
            if (isGoodHour) {
                goodHours.add(hour)
            }
        }
        return goodHours
    }

    private fun formatDateTime(dateTime: LocalDateTime): String {

        val stringBuilder = StringBuilder()

        val minute = dateTime.minute
        var hour = dateTime.hour % 12
        if (hour == 0) {
            hour = 12
        }

        val amPm = if (dateTime.hour < 12) " am" else " pm"

        stringBuilder.append(hour.toString())
        stringBuilder.append(":")

        if (minute < 10) {
            stringBuilder.append('0')
        }
        stringBuilder.append(minute.toString())
        stringBuilder.append(amPm)

        return stringBuilder.toString()
    }

    private fun isValid(
        timeRange: IntRange,
        hour: Int,
        currentTimeZone: TimeZone,
        otherTimeZone: TimeZone
    ): Boolean {

        if (hour !in timeRange) {
            return false
        }

        val currentUTCNow = Clock.System.now()
        val currentOtherDateTime: LocalDateTime = currentUTCNow.toLocalDateTime(otherTimeZone)

        val otherDateTimeWithHour = LocalDateTime(
            currentOtherDateTime.year,
            currentOtherDateTime.monthNumber,
            currentOtherDateTime.dayOfMonth,
            hour, 0, 0, 0
        )

        val localInstant = otherDateTimeWithHour.toInstant(currentTimeZone)
        val convertedTime = localInstant.toLocalDateTime(otherTimeZone)

        return convertedTime.hour in timeRange
    }
}