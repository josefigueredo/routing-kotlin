package com.josefigueredo.examples.waysofroute.service

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.stereotype.Component

@Component
class ReactiveNumberService {

    fun echoNumber(number: Int): Flow<Int> = flow {
        delay(1500)// Delay of 500ms to simulate computation
        emit(number) // Emit the value
    }

    fun generateRangeOfInts(count: Int): Flow<Int> = flow {
        for (i in 1..count) {
            delay(100) // Delay of 100ms to simulate computation
            emit(i) // Emit the next value
        }
    }

}