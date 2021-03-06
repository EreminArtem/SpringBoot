package ru.eremin.springboot.lessons.integration.listner;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import ru.eremin.springboot.lessons.integration.gateway.SimpleMessageGateway;
import ru.eremin.springboot.lessons.integration.message.SimpleMessage;

/**
 * @autor Eremin Artem on 29.01.2019.
 */

@MessageEndpoint
public class SimpleMessageListener {

    @ServiceActivator(inputChannel = SimpleMessageGateway.CHANNEL)
    public void handler(final SimpleMessage message,
                        @Header("groupId") final String groupId,
                        @Header("theme") final String theme) {
        System.out.println(message.getText());
        System.out.println(groupId);
        System.out.println(theme);
    }
}
