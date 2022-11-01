package com.kyungeun.cleanarchitecture.data.schedule.mapper

import com.kyungeun.cleanarchitecture.data.database.pray.model.PrayEntity
import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule


object PrayScheduleMapper {

    fun List<PraySchedule>.toPrayEntities(): List<PrayEntity> {
        val prayEntities = ArrayList<PrayEntity>()

        forEach {
            prayEntities.add(PrayEntity(it.id, it.city, it.name, it.time))
        }
        return prayEntities
    }
}