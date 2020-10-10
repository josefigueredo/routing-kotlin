package com.josefigueredo.examples.waysofroute.dsl.imperative

import com.josefigueredo.examples.waysofroute.handler.ImperativeHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.coRouter

@Component
class DslRouterWithImperativeHandler {

    @Bean
    fun route(@Autowired handler: ImperativeHandler) = coRouter() {
        (accept(TEXT_HTML) and "/dsl/imperative").nest {
            GET("/echo/{number}").invoke(handler::echoNumber)
            GET("/range/{count}").invoke(handler::generateRangeOfInts)
        }
    }

}