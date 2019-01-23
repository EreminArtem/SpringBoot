package ru.eremin.springboot.lessons.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Note {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String description;

    @Column
    private String data;

    @ManyToOne
    private Category category;

    public Note(final String description, final String data, final Category category) {
        this.description = description;
        this.data = data;
        this.category = category;
    }
}
