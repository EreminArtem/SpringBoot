package ru.eremin.springboot.lessons.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eremin.springboot.lessons.integration.gateway.TypedMessageGateway;
import ru.eremin.springboot.lessons.integration.message.SimpleMessage;
import ru.eremin.springboot.lessons.integration.gateway.SimpleMessageGateway;
import ru.eremin.springboot.lessons.integration.message.TypedMessage;

import java.util.UUID;

/**
 * @autor Eremin Artem on 29.01.2019.
 */

@RestController
@RequestMapping("/integration")
public class MessageController {

    private SimpleMessageGateway simpleMessageGateway;
    private TypedMessageGateway typedMessageGateway;

    @Autowired
    public MessageController(final SimpleMessageGateway simpleMessageGateway, final TypedMessageGateway typedMessageGateway) {
        this.simpleMessageGateway = simpleMessageGateway;
        this.typedMessageGateway = typedMessageGateway;
    }

    @RequestMapping("/simple")
    public String sendSimpleMessage() {
        simpleMessageGateway.fire(MessageBuilder
                .withPayload(new SimpleMessage("Hello Simple"))
                .setHeader("groupId", UUID.randomUUID().toString())
                .setHeader("theme", "work")
                .build());
        return "simple message";
    }

    @RequestMapping("/usual")
    public String sendUsualMessage() {
        final TypedMessage message = new TypedMessage("usual", TypedMessage.Type.USUAL);
        typedMessageGateway.fire(MessageBuilder
                .withPayload(message)
                .setHeader("type", message.getType())
                .build());
        return "usual message";
    }

    @RequestMapping("/warning")
    public String sendWarningMessage() {
        final TypedMessage message = new TypedMessage("warning", TypedMessage.Type.WARNING);
        typedMessageGateway.fire(MessageBuilder
                .withPayload(message)
                .setHeader("type", message.getType())
                .build());
        return "warning message";
    }
}
