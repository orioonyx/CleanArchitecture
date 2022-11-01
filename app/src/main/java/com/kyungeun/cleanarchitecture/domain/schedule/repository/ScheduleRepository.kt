package com.kyungeun.cleanarchitecture.domain.schedule.repository

import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule
import com.kyungeun.cleanarchitecture.domain.schedule.model.PrayScheduleRequest

interface ScheduleRepository {

    suspend fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule>
}