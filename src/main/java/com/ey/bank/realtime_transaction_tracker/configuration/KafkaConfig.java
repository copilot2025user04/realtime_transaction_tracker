package com.ey.bank.realtime_transaction_tracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
@Configuration
public class KafkaConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new MappingJackson2MessageConverter();
    }
} 