package com.kyungeun.cleanarchitecture.data.source.remote

import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProvider {

    fun iO() = Dispatchers.IO

    fun default() = Dispatchers.Default

    fun main() = Dispatchers.Main
}