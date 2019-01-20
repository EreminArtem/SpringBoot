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
public class Note {

    private String id = UUID.randomUUID().toString();
    private String description;
    private String data;
    private String categoryId;

    public Note(final String description, final String data, final String categoryId) {
        this.description = description;
        this.data = data;
        this.categoryId = categoryId;
    }
}
