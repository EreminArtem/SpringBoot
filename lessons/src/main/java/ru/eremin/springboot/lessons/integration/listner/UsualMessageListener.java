package ru.eremin.springboot.lessons.integration.listner;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import ru.eremin.springboot.lessons.integration.message.TypedMessage;

/**
 * @autor Eremin Artem on 30.01.2019.
 */

@MessageEndpoint
public class UsualMessageListener {

    @ServiceActivator(inputChannel = "usualMessageChannel")
    public void handler(final TypedMessage message) {
        System.out.println("usual listener");
        System.out.println(message.getText());
    }
}
