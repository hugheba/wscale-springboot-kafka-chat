package com.naked.cams.chat.kafka

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

interface IBrokerChannel {

    @Input("message-down")
    SubscribableChannel inbound()

//    @Input("message-up")
//    SubscribableChannel messagesIncoming()
}
