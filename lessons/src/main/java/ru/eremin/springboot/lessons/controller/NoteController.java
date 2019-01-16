package ru.eremin.springboot.lessons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.eremin.springboot.lessons.entity.Category;
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

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String notes(@RequestParam("id") String id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id));
        model.addAttribute("notes", repository.findNotesByCategoryId(id));
        return "note-view";
    }

    @RequestMapping(value = "/edit-note", method = RequestMethod.GET)
    public String edit(@RequestParam("id") String id, Map<String, Object> model) {
        final Note note = repository.findById(id);
        model.put("note", note);
        return "note-edit-view";
    }

    @RequestMapping(value = "save-note", method = RequestMethod.POST)
    public String save(@ModelAttribute("note") Note note,
                       @ModelAttribute("category") Category category) {
        repository.merge(note);
        return "redirect:/notes?id=" + category.getId();
    }

    @RequestMapping(value = "/delete-note", method = RequestMethod.GET)
    public String delete(@RequestParam("id") String id,
                         @ModelAttribute("category") Category category) {
        repository.delete(id);
        return "redirect:/notes?id=" + category.getId();
    }

    @RequestMapping(value = "/create-note", method = RequestMethod.GET)
    public String create(@ModelAttribute("category") Category category) {
        final Note note = new Note("New Note", "", category.getId());
        repository.merge(note);
        System.out.println(category.getName());
        System.out.println(repository.findAll());
        return "redirect:/notes?id=" + category.getId();
    }
}
