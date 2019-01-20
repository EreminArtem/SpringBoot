package ru.eremin.springboot.lessons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.eremin.springboot.lessons.entity.Note;
import ru.eremin.springboot.lessons.repository.CategoryRepository;
import ru.eremin.springboot.lessons.repository.NoteRepository;

import java.util.Map;

/**
 * @autor Eremin Artem on 16.01.2019.
 */

@Controller
public class NoteController {

    @Autowired
    private NoteRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public String notes(@PathVariable("id") String id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id))
                .addAttribute("notes", repository.findNotesByCategoryId(id));
        return "note-view";
    }

    @RequestMapping(value = "/edit-note", method = RequestMethod.GET)
    public String edit(@RequestParam("id") String id, Map<String, Object> model) {
        final Note note = repository.findById(id);
        model.put("note", note);
        return "note-edit-view";
    }

    @RequestMapping(value = "/save-note", method = RequestMethod.POST)
    public String save(@ModelAttribute("note") Note note) {
        repository.merge(note);
        return "redirect:/notes/" + note.getCategoryId();
    }

    @RequestMapping(value = "/delete-note", method = RequestMethod.GET)
    public String delete(@RequestParam("id") String id) {
        final String categoryId = repository.findById(id).getCategoryId();
        repository.delete(id);
        return "redirect:/notes/" + categoryId;
    }

    @RequestMapping(value = "/create-note/{id}", method = RequestMethod.GET)
    public String create(@PathVariable("id") String id) {
        final Note note = new Note("New Note", "", id);
        repository.merge(note);
        return "redirect:/notes/" + id;
    }
}
