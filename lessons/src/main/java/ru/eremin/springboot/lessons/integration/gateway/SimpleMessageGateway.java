package ru.eremin.springboot.lessons.integration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import ru.eremin.springboot.lessons.integration.message.SimpleMessage;

/**
 * @autor Eremin Artem on 29.01.2019.
 */

@MessagingGateway(name = SimpleMessageGateway.GATEWAY, defaultRequestChannel = SimpleMessageGateway.CHANNEL)
public interface SimpleMessageGateway {

    String CHANNEL = "simpleMessageChannel";
    String GATEWAY = "simpleMessageGateway";

    @Gateway
    void fire(Message<SimpleMessage> message);
}
