package ru.eremin.springboot.lessons.repository;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.eremin.springboot.lessons.entity.Note;

import java.util.*;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class NoteRepository {

    private Map<String, Note> notes = new LinkedHashMap<>();

    public Collection<Note> findAll() {
        return notes.values();
    }

    public Note findById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return notes.get(id);
    }

    public Collection<Note> findNotesByCategoryId (@Nullable final String categoryId){
        if (categoryId == null || categoryId.isEmpty()) return null;
        final List<Note> notesByCategory = new ArrayList<>();
        for (Note note : notes.values()) {
            if(categoryId.equals(note.getCategoryId())) notesByCategory.add(note);
        }
        return notesByCategory;
    }

    public void merge(@Nullable final Note note) {
        if (note == null) return;
        if (note.getId() == null || note.getId().isEmpty()) return;
        notes.put(note.getId(), note);
    }

    public void delete(@Nullable final String id) {
        if (id == null || id.isEmpty()) return;
        notes.remove(id);
    }
}
