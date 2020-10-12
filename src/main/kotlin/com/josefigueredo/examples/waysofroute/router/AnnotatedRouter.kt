package com.josefigueredo.examples.waysofroute.router

import com.josefigueredo.examples.waysofroute.handler.CorutineHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/annotated")
class AnnotatedRouter(@Autowired val handler: CorutineHandler) {

    @GetMapping("/echo/{number}")
    @ResponseBody
    suspend fun echoNumber(@PathVariable number: Int): Int = handler.echoNumber(number).first()

    @GetMapping(path = ["/range/{count}"],
            produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    @ResponseBody
    suspend fun rangeNumbers(@PathVariable count: Int): Flow<Int> = handler.generateRangeOfInts(count)

}