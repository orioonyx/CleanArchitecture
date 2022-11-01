package com.kyungeun.cleanarchitecture.data.schedule.source

import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule
import com.kyungeun.cleanarchitecture.domain.schedule.model.PrayScheduleRequest


interface ScheduleEntityData {

    suspend fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule>

    suspend fun addPraySchedules(praySchedules: List<PraySchedule>)
}