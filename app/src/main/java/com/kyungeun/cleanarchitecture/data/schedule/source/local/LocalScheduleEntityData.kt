package com.kyungeun.cleanarchitecture.data.schedule.source.local


import com.kyungeun.cleanarchitecture.data.database.pray.dao.PrayDao
import com.kyungeun.cleanarchitecture.data.schedule.mapper.PrayEntityMapper.toPraySchedules
import com.kyungeun.cleanarchitecture.data.schedule.mapper.PrayScheduleMapper.toPrayEntities
import com.kyungeun.cleanarchitecture.data.schedule.source.ScheduleEntityData
import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule
import com.kyungeun.cleanarchitecture.domain.schedule.model.PrayScheduleRequest
import com.kyungeun.cleanarchitecture.util.TimeUtil
import javax.inject.Inject

class LocalScheduleEntityData @Inject constructor(
    private val prayDao: PrayDao
) : ScheduleEntityData {

    override suspend fun getPraySchedule(prayScheduleRequest: PrayScheduleRequest): List<PraySchedule> {
        val from = TimeUtil.getTimestamp(prayScheduleRequest.date)
        val to = TimeUtil.getTimestamp(prayScheduleRequest.date, 1)

        return prayDao.getPraySchedule(prayScheduleRequest.city, from, to).toPraySchedules()
    }

    override suspend fun addPraySchedules(praySchedules: List<PraySchedule>) {
        val prayEntities = praySchedules.toPrayEntities()

        prayDao.insert(prayEntities)
    }
}