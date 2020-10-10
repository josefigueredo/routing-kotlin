package com.josefigueredo.examples.waysofroute.dsl.functional

import com.josefigueredo.examples.waysofroute.handler.FunctionalHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class DslRouterWithFunctionalHandler {

    @Bean
    fun funcRoute(@Autowired handler: FunctionalHandler) = router() {
        (accept(TEXT_HTML) and "/dsl/functional").nest {
            GET("/echo/{number}").invoke(handler::echoNumber)
            GET("/range/{count}").invoke(handler::generateRangeOfInts)
        }
    }
}
