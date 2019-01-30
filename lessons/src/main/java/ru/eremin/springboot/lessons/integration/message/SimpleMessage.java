package ru.eremin.springboot.lessons.integration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @autor Eremin Artem on 29.01.2019.
 */

@Getter
@Setter
@NoArgsConstructor
public class SimpleMessage {

    private String text;

    public SimpleMessage(final String text) {
        this.text = text;
    }
}
