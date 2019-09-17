package com.naked.cams.chat.kafka

import com.google.gson.Gson
import org.apache.kafka.common.serialization.Serializer

class MessageSerializer implements Serializer<Object> {

    @Override
    byte[] serialize(String topic, Object data) {
        new Gson().toJson(data).bytes
    }

    @Override
    void configure(Map<String,?> config, boolean isKey) {}

    @Override
    void close() {}
}
