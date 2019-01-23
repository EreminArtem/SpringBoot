package ru.eremin.springboot.lessons.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Category {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String name;

    public Category(final String name) {
        this.name = name;
    }
}
