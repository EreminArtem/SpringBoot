package ru.eremin.springboot.lessons.integration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @autor Eremin Artem on 29.01.2019.
 */

@Getter
@Setter
@NoArgsConstructor
public class DateMessage {

    private String text;

    public DateMessage(final String text) {
        this.text = text + new Date().toString();
    }
}
