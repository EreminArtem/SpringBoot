package ru.eremin.springboot.lessons.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Header;
import ru.eremin.springboot.lessons.integration.gateway.TypedMessageGateway;
import ru.eremin.springboot.lessons.integration.message.TypedMessage;

/**
 * @autor Eremin Artem on 30.01.2019.
 */

@MessageEndpoint
public class TypedMessageRouter {

    @Router(inputChannel = TypedMessageGateway.CHANNEL)
    public String route(@Header("type") final TypedMessage.Type type, final TypedMessage message) {

        switch (type) {
            case USUAL:
                return "usualMessageChannel";
            case WARNING:
                return "warningMessageChannel";
            default:
                return "nullableChannel";
        }
    }
}
