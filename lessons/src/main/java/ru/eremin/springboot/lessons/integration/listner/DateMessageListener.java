package ru.eremin.springboot.lessons.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;

/**
 * @autor Eremin Artem on 29.01.2019.
 */

@MessageEndpoint
public class DateMessageListener {

    @ServiceActivator(inputChannel = DateMessageGateway.CHANNEL)
    public void handler(final DateMessage message, @Header ("groupId") final String groupId){
        System.out.println(message.getText());
        System.out.println(groupId);
    }
}
