package com.josefigueredo.examples.waysofroute.annotated.imperative

import com.josefigueredo.examples.waysofroute.handler.ImperativeHandler
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/annotated/imperative")
class AnnotatedRouterWithImperativeHandler(@Autowired val handler: ImperativeHandler) {

    @GetMapping("/echo/{number}")
    suspend fun echoNumber(@PathVariable number: Int): Int = handler.echoNumber(number)

    @GetMapping(path = ["/range/{count}"],
            produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    @ResponseBody
    suspend fun rangeNumbers(@PathVariable count: Int): Flow<Int> = handler.generateRangeOfInts(count)

}