package ru.eremin.springboot.lessons.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category {

    private String id = UUID.randomUUID().toString();
    private String name;

    public Category(final String name) {
        this.name = name;
    }
}
