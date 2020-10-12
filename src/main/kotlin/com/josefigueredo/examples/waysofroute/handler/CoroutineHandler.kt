package com.josefigueredo.examples.waysofroute.handler

import com.josefigueredo.examples.waysofroute.service.ReactiveNumberService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class CoroutineHandler(@Autowired val service: ReactiveNumberService) {

    suspend fun echoNumber(request: ServerRequest): ServerResponse =
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_STREAM_JSON)
                    .bodyAndAwait(
                            service.echoNumber(
                                    request.pathVariable("number")
                                            .toInt()
                            )
                    )

    suspend fun generateRangeOfInts(request: ServerRequest): ServerResponse =
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_STREAM_JSON)
                    .bodyAndAwait(
                            service.generateRangeOfInts(
                                    request.pathVariable("count")
                                            .toInt()
                            )
                    )

    suspend fun echoNumber(number: Int): Flow<Int> =
            service.echoNumber(number)

    suspend fun generateRangeOfInts(count: Int): Flow<Int> =
            service.generateRangeOfInts(count)
}