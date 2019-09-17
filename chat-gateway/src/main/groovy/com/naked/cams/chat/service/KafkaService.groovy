package com.naked.cams.chat.service

import com.google.gson.Gson
import com.naked.cams.chat.kafka.Event
import com.naked.cams.chat.kafka.EventType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.lang.Nullable
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback

@Service
class KafkaService {

    @Autowired KafkaTemplate kafkaTemplate
    @Autowired Gson gson

    void sendMessage(String source, String topic, Object message, Map<String,String> attributes, EventType eventType = EventType.MESSAGE) {
        Event event = new Event(
                eventType: eventType,
                source: source,
                message: message,
                clientIp: attributes.ip,
                auth: attributes.auth
        )
        String msgStr = gson.toJson(message)
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, msgStr)
        future.addCallback(new ListenableFutureCallback<SendResult>() {
            @Override
            void onFailure(Throwable ex) {
                println "${msgStr} to ${topic} failed; ${ex.message}"
            }

            @Override
            void onSuccess(@Nullable SendResult result) {
                println "Successfully sent ${msgStr} to ${topic}"
            }
        })
    }
}
