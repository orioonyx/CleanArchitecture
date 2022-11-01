package com.kyungeun.cleanarchitecture.data.schedule.api


import com.kyungeun.cleanarchitecture.BuildConfig
import com.kyungeun.cleanarchitecture.data.schedule.model.PrayScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayApi {

    @GET("/jakarta/daily.json")
    suspend fun getPraySchedule(
        @Query("city") city: String,
        @Query("key") key: String? = BuildConfig.API_KEY
    ): PrayScheduleResponse
}