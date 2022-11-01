package com.kyungeun.cleanarchitecture.data.schedule.mapper

import com.kyungeun.cleanarchitecture.data.database.pray.model.PrayEntity
import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule

object PrayEntityMapper {

    fun List<PrayEntity>.toPraySchedules(): List<PraySchedule> {
        val praySchedules = ArrayList<PraySchedule>()
        forEach {
            praySchedules.add(PraySchedule(it.city, it.name, it.time, it.id))
        }

        return praySchedules
    }
}