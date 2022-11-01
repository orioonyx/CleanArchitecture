package com.kyungeun.cleanarchitecture.data.schedule.repository


import com.kyungeun.cleanarchitecture.data.schedule.factory.ScheduleFactory
import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule
import com.kyungeun.cleanarchitecture.domain.schedule.model.PrayScheduleRequest
import com.kyungeun.cleanarchitecture.domain.schedule.repository.ScheduleRepository
import com.kyungeun.cleanarchitecture.util.Source
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleFactory: ScheduleFactory
) : ScheduleRepository {

    override suspend fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        return scheduleFactory.create(Source.LOCAL).getPraySchedule(prayScheduleRequest)
            .ifEmpty { syncPraySchedule(prayScheduleRequest) }
    }

    private suspend fun syncPraySchedule(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        return scheduleFactory.create(Source.NETWORK).getPraySchedule(prayScheduleRequest)
            .also { prayScheduleFromNetwork ->
                scheduleFactory.create(Source.LOCAL).addPraySchedules(prayScheduleFromNetwork)
            }
    }
}