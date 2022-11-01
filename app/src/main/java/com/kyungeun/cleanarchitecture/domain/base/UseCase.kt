package com.kyungeun.cleanarchitecture.domain.base

interface UseCase<T, U> {

    fun execute(param: T): U
}