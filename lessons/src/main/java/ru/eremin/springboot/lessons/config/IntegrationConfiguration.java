package ru.eremin.springboot.lessons.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

/**
 * @autor Eremin Artem on 29.01.2019.
 */

@EnableAutoConfiguration
@EnableIntegration
@IntegrationComponentScan("ru.eremin.springboot.lessons.integration")
public class IntegrationConfiguration {

    @Bean
    public MessageChannel simpleMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel dateMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel typedMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel warningMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel usualMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel nullableChannel() {
        return new DirectChannel();
    }

}
