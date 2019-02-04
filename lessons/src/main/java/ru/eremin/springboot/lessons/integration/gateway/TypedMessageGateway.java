package ru.eremin.springboot.lessons.integration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import ru.eremin.springboot.lessons.integration.message.TypedMessage;

/**
 * @autor Eremin Artem on 30.01.2019.
 */

@MessagingGateway(name = TypedMessageGateway.GATEWAY, defaultRequestChannel = TypedMessageGateway.CHANNEL)
public interface TypedMessageGateway {

    String CHANNEL = "typedMessageChannel";
    String GATEWAY = "typedMessageGateway";

    @Gateway
    void fire(Message<TypedMessage> message);

}
