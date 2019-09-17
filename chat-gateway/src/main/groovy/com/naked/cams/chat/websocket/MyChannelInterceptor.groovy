package com.naked.cams.chat.websocket

import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.messaging.support.ChannelInterceptor

class MyChannelInterceptor implements ChannelInterceptor {

    @Override
    Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message)
        StompCommand command = accessor.getCommand()
        if (StompCommand.SUBSCRIBE == command) {

        }
        return message
    }

}
