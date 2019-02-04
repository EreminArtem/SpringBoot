package ru.eremin.springboot.lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eremin.springboot.lessons.entity.Note;
import ru.eremin.springboot.lessons.repository.NoteRepository;

import static org.junit.Assert.assertEquals;

/**
 * @autor Eremin Artem on 04.02.2019.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {LessonsApplication.class})
@TestPropertySource(locations = "classpath:application.properties")
public class NoteRepositoryTest {

    @Autowired
    @Qualifier(NoteRepository.NAME)
    private NoteRepository noteRepository;

    @Test
    public void insertTest() {
        final int count = noteRepository.findAll().size();
        final Note note = new Note("TestDescription", "TestData", null);
        noteRepository.save(note);
        assertEquals(count + 1, noteRepository.findAll().size());
        noteRepository.delete(note);
        assertEquals(count, noteRepository.findAll().size());
    }

}
