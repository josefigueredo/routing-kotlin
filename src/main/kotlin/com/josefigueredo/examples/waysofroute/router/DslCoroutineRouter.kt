package com.josefigueredo.examples.waysofroute.router

import com.josefigueredo.examples.waysofroute.handler.CoroutineHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.coRouter

@Component
class DslCoroutineRouter {

    @Bean
    fun coRoute(@Autowired handler: CoroutineHandler) = coRouter() {
        (accept(TEXT_HTML) and "/dsl-coroutine").nest {
            GET("/echo/{number}")
                    .invoke(handler::echoNumber)
            GET("/range/{count}")
                    .invoke(handler::generateRangeOfInts)
        }
    }
}