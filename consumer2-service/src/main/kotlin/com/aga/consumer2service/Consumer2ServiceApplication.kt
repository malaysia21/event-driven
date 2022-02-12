package com.aga.consumer2service

import com.aga.consumer2service.message.EventMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Consumer

@SpringBootApplication
class Consumer2ServiceApplication {

    var logger: Logger = LoggerFactory.getLogger(Consumer2ServiceApplication::class.java)

//    @Bean
//    fun eventConsumer(): Consumer<EventMessage> = Consumer { logger.info("Received messages: {}", it) }


    @Bean
    fun fireForget(): Consumer<EventMessage> = Consumer { logger.info("Received messages(fireForget): {}", it) }


    @Bean
    fun process(): Consumer<EventMessage> = Consumer { logger.info("Received messages(process): {}", it) }
}


fun main(args: Array<String>) {
    runApplication<Consumer2ServiceApplication>(*args)
}
