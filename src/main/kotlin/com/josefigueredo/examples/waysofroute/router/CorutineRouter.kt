package com.josefigueredo.examples.waysofroute.router

import com.josefigueredo.examples.waysofroute.handler.CorutineHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.coRouter

@Component
class CorutineRouter {

    @Bean
    fun coRoute(@Autowired handler: CorutineHandler) = coRouter() {
        (accept(TEXT_HTML) and "/dsl-corutine").nest {
            GET("/echo/{number}").invoke(handler::echoNumber)
            GET("/range/{count}").invoke(handler::generateRangeOfInts)
        }
    }

}