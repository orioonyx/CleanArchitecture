package com.kyungeun.cleanarchitecture.domain.schedule.usecase

import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule
import com.kyungeun.cleanarchitecture.domain.schedule.model.PrayScheduleRequest
import com.kyungeun.cleanarchitecture.domain.schedule.repository.ScheduleRepository
import javax.inject.Inject

class GetPraySchedules @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {

    suspend fun execute(request: PrayScheduleRequest): List<PraySchedule> {
        return scheduleRepository.getPraySchedules(request)
    }
}