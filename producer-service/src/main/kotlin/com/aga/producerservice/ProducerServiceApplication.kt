package com.aga.producerservice

import com.aga.producerservice.message.EventMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Supplier

@SpringBootApplication
class ProducerServiceApplication {

    @Value("\${event.supplier.enabled}")
    val supplierEnabled: Boolean = false

    val log: Logger = LoggerFactory.getLogger(ProducerServiceApplication::class.java)

    var id: Int = 0

    @Bean
    fun eventSupplier(): Supplier<EventMessage?> = Supplier {
        createEvent()
    }

    private fun createEvent(): EventMessage? {
        return if(supplierEnabled) {
            val messageValue: Int = ++id;
            log.info("Messages produced: {}", messageValue)
            EventMessage(messageValue, "Message")
        }
        else null
    }





}

fun main(args: Array<String>) {
    runApplication<ProducerServiceApplication>(*args)
}
