package ru.eremin.springboot.lessons.integration.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @autor Eremin Artem on 30.01.2019.
 */

@Getter
@Setter
@NoArgsConstructor
public class TypedMessage {

    public enum Type {
        WARNING, USUAL
    }

    private String text;
    private Type type = Type.USUAL;

    public TypedMessage(final String text, final Type type) {
        this.text = text;
        this.type = type;
    }
}
