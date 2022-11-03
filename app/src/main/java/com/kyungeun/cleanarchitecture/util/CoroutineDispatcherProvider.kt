package com.kyungeun.cleanarchitecture.util

import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProvider {

    fun iO() = Dispatchers.IO

    fun default() = Dispatchers.Default

    fun main() = Dispatchers.Main
}