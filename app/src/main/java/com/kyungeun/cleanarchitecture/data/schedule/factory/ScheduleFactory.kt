package com.kyungeun.cleanarchitecture.data.schedule.factory

import com.kyungeun.cleanarchitecture.data.schedule.source.ScheduleEntityData
import com.kyungeun.cleanarchitecture.data.schedule.source.local.LocalScheduleEntityData
import com.kyungeun.cleanarchitecture.data.schedule.source.network.NetworkScheduleEntityData
import com.kyungeun.cleanarchitecture.util.Source
import javax.inject.Inject

class ScheduleFactory @Inject constructor(
    private val networkScheduleEntityData: NetworkScheduleEntityData,
    private val localScheduleEntityData: LocalScheduleEntityData
) {

    fun create(source: Source): ScheduleEntityData {
        return when (source) {
            Source.NETWORK -> networkScheduleEntityData
            else -> localScheduleEntityData
        }
    }
}