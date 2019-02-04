package ru.eremin.springboot.lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eremin.springboot.lessons.entity.Note;

import static org.junit.Assert.assertEquals;

/**
 * @autor Eremin Artem on 04.02.2019.
 */

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NotePersistenceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void persistTest() {
        final long count = getCountNote();
        final Note note = new Note("TestDescription", "TestData", null);
        entityManager.persist(note);
        assertEquals(count + 1, getCountNote());
        entityManager.getEntityManager().createQuery("DELETE FROM Note e WHERE e.id = :id")
                .setParameter("id", note.getId())
                .executeUpdate();
        assertEquals(count, getCountNote());
    }

    public long getCountNote() {
        return entityManager.getEntityManager().createQuery("SELECT count(e) FROM Note e", Long.class).getSingleResult();
    }
}
