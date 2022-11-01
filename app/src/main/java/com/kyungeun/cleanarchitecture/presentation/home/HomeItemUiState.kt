package com.kyungeun.cleanarchitecture.presentation.home

import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule


data class HomeItemUiState(
    val city: String,
    val schedules: List<PraySchedule>
)