package com.aga.producerservice

import com.aga.producerservice.message.EventMessage
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/producer")
class ProducerController (val streamBridge: StreamBridge) {

    var messageValue: Int = 0

    @PostMapping("/{message}")
    fun sendEvent(@PathVariable message: String): Boolean {
        return streamBridge.send("eventSupplier-out-0",  EventMessage(++messageValue, message))
    }

    @PostMapping("/{message}/process/{process}")
    fun sendEventWithHeader(@PathVariable message: String, @PathVariable process: Boolean): Boolean {
        return streamBridge.send("eventSupplier-out-0",
            MessageBuilder.createMessage(
                EventMessage(++messageValue, message),
                MessageHeaders(mutableMapOf(Pair<String, Any>("to_process", process))
        )))
    }


}