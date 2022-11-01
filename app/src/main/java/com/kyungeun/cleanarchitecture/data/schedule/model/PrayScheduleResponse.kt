package com.kyungeun.cleanarchitecture.data.schedule.model

class PrayScheduleResponse(
    val city: String? = null,
    val state: String? = null,
    val items: List<ItemsItem?>? = null
)

data class ItemsItem(
    val asr: String? = null,
    val isha: String? = null,
    val shurooq: String? = null,
    val date_for: String? = null,
    val dhuhr: String? = null,
    val fajr: String? = null,
    val maghrib: String? = null
)

data class TodayWeather(
    val temperature: String? = null,
    val pressure: String? = null
)