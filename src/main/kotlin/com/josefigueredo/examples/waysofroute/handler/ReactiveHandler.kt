package com.josefigueredo.examples.waysofroute.handler

import com.josefigueredo.examples.waysofroute.service.ReactiveNumberService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class ReactiveHandler(@Autowired val service: ReactiveNumberService) {

    fun echoNumber(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_STREAM_JSON)
                    .body(
                            echoNumber(
                                    request.pathVariable("number").toInt()
                            ), Flow::class.java
                    )

    fun generateRangeOfInts(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_STREAM_JSON)
                    .body(
                            generateRangeOfInts(
                                    request.pathVariable("count").toInt()
                            ), Flow::class.java
                    )

    fun echoNumber(number: Int): Flow<Int> = service.echoNumber(number)

    fun generateRangeOfInts(count: Int): Flow<Int> = service.generateRangeOfInts(count)
}