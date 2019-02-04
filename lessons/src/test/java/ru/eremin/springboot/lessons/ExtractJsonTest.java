package ru.eremin.springboot.lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eremin.springboot.lessons.entity.Category;
import ru.eremin.springboot.lessons.entity.Note;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @autor Eremin Artem on 04.02.2019.
 */

@SpringBootTest
@AutoConfigureJsonTesters
@RunWith(SpringJUnit4ClassRunner.class)
public class ExtractJsonTest {

    @Autowired(required = false)
    private JacksonTester<Note> jacksonTester;

    @Test
    public void jsonTest() throws IOException {
        final Note note = new Note("TestDescription", "TestData", new Category());
        assertThat(jacksonTester.write(note))
                .extractingJsonPathStringValue("@.description")
                .isEqualTo("TestDescription");
    }
}
