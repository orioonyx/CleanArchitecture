package com.kyungeun.cleanarchitecture.data.schedule.source.network


import com.kyungeun.cleanarchitecture.data.schedule.api.PrayApi
import com.kyungeun.cleanarchitecture.data.schedule.mapper.PrayScheduleResponseMapper.toPraySchedules
import com.kyungeun.cleanarchitecture.data.schedule.source.ScheduleEntityData
import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule
import com.kyungeun.cleanarchitecture.domain.schedule.model.PrayScheduleRequest
import javax.inject.Inject

class NetworkScheduleEntityData @Inject constructor(
    private val prayApi: PrayApi
) : ScheduleEntityData {

    override suspend fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        return prayApi.getPraySchedule(prayScheduleRequest.city)
            .toPraySchedules()
    }

    override suspend fun addPraySchedules(praySchedules: List<PraySchedule>) {
        //no op
    }
}