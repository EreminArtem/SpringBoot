package ru.eremin.springboot.lessons.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import ru.eremin.springboot.lessons.integration.gateway.SimpleMessageGateway;
import ru.eremin.springboot.lessons.integration.message.DateMessage;
import ru.eremin.springboot.lessons.integration.message.SimpleMessage;

/**
 * @autor Eremin Artem on 29.01.2019.
 */

@MessageEndpoint
public class SimpleMessageTransformer {

    @Transformer(inputChannel = SimpleMessageGateway.CHANNEL, outputChannel = "dateMessageChannel")
    public DateMessage transform(final SimpleMessage message) {
        return new DateMessage(message.getText());
    }
}
