package ru.eremin.springboot.lessons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.eremin.springboot.lessons.entity.Category;
import ru.eremin.springboot.lessons.entity.Note;
import ru.eremin.springboot.lessons.repository.CategoryRepository;
import ru.eremin.springboot.lessons.repository.NoteRepository;

import java.util.Map;
import java.util.Optional;

/**
 * @autor Eremin Artem on 16.01.2019.
 */

@Controller
public class NoteController {

    @Autowired
    @Qualifier(NoteRepository.NAME)
    private NoteRepository repository;

    @Autowired
    @Qualifier(CategoryRepository.NAME)
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public String notes(@PathVariable("id") String id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).orElse(new Category()))
                .addAttribute("notes", repository.findNoteByCategoryId(id));
        return "note-view";
    }

    @RequestMapping(value = "/edit-note", method = RequestMethod.GET)
    public String edit(@RequestParam("id") String id, Map<String, Object> model) {
        final Optional<Note> optionalNote = repository.findById(id);
        final Note note = optionalNote.orElse(new Note());
        model.put("note", note);
        return "note-edit-view";
    }

    @RequestMapping(value = "/save-note", method = RequestMethod.POST)
    public String save(@ModelAttribute("note") Note note) {
        Note noteTmp = repository.findById(note.getId()).orElse(new Note());
        noteTmp.setDescription(note.getDescription());
        noteTmp.setData(note.getData());
        repository.save(noteTmp);
        return "redirect:/notes/" + note.getCategory().getId();
    }

    @RequestMapping(value = "/delete-note", method = RequestMethod.GET)
    public String delete(@RequestParam("id") String id) {
        final String categoryId = repository.findById(id).orElse(new Note()).getCategory().getId();
        repository.deleteById(id);
        return "redirect:/notes/" + categoryId;
    }

    @RequestMapping(value = "/create-note/{id}", method = RequestMethod.GET)
    public String create(@PathVariable("id") String id) {
        final Optional<Category> optionalCategory = categoryRepository.findById(id);
        final Note note = new Note("New Note", "", optionalCategory.orElse(new Category()));
        repository.save(note);
        return "redirect:/notes/" + id;
    }
}
