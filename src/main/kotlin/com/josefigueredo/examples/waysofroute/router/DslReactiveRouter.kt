package com.josefigueredo.examples.waysofroute.router

import com.josefigueredo.examples.waysofroute.handler.ReactiveHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class DslReactiveRouter {

    @Bean
    fun route(@Autowired handler: ReactiveHandler) = router() {
        (accept(TEXT_HTML) and "/dsl-reactive").nest {
            GET("/echo/{number}")
                    .invoke(handler::echoNumber)
            GET("/range/{count}")
                    .invoke(handler::generateRangeOfInts)
        }
    }
}
