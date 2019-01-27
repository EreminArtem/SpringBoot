package ru.eremin.springboot.lessons.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eremin.springboot.lessons.entity.Category;
import ru.eremin.springboot.lessons.entity.Note;

import java.util.List;

/**
 * @autor Eremin Artem on 22.01.2019.
 */

@Repository (NoteRepository.NAME)
public interface NoteRepository extends JpaRepository<Note, String> {

    String NAME = "noteRepository";

    List<Note> findNoteByCategoryId(String id);

    List<Note> findNoteByCategory(Category category);

}
