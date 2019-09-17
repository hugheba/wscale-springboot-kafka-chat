package com.naked.cams.chat.kafka

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


class KafkaProducerConfig {

//    @Bean
    ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = [
                (ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG): StringSerializer,
                (ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG): StringSerializer
        ]
        new DefaultKafkaProducerFactory<String, String>(configProps)
    }

//    @Bean
    KafkaTemplate<String, String> kafkaTemplate() {
        new KafkaTemplate<String, String>(producerFactory())
    }
}
