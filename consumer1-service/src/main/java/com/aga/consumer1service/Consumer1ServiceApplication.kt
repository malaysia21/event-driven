package com.aga.consumer1service

import com.aga.consumer1service.message.EventMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Consumer

@SpringBootApplication
class Consumer1ServiceApplication {

    var logger: Logger = LoggerFactory.getLogger(Consumer1ServiceApplication::class.java)

    @Bean
    fun eventConsumer(): Consumer<EventMessage> = Consumer { logger.info("Received messages: {}", it) }

}

fun main(args: Array<String>) {
    runApplication<Consumer1ServiceApplication>(*args)
}
