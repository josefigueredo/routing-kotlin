package com.josefigueredo.examples.waysofroute.router

import com.josefigueredo.examples.waysofroute.handler.ReactiveHandler
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/annotated-reactive")
class AnnotatedReactiveRouter(@Autowired val handler: ReactiveHandler) {

    @GetMapping(path = ["/echo/{number}"],
            produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun echoNumber(@PathVariable number: Int): Flow<Int> =
            handler.echoNumber(number)

    @GetMapping(path = ["/range/{count}"],
            produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun rangeNumbers(@PathVariable count: Int): Flow<Int> =
            handler.generateRangeOfInts(count)
}
