package ru.eremin.springboot.lessons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.eremin.springboot.lessons.entity.Category;
import ru.eremin.springboot.lessons.repository.CategoryRepository;

import java.util.Map;
import java.util.Optional;

/**
 * @autor Eremin Artem on 16.01.2019.
 */

@Controller
public class CategoryController {

    @Autowired
    @Qualifier(CategoryRepository.NAME)
    private CategoryRepository repository;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String categories(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "category-view";
    }

    @RequestMapping(value = "/category-edit-view", method = RequestMethod.GET)
    public String edit(@RequestParam("id") String id, Map<String, Object> model) {
        final Optional<Category> optionalCategory = repository.findById(id);
        final Category category = optionalCategory.orElse(new Category());
        model.put("category", category);
        return "category-edit-view";
    }

    @RequestMapping(value = "save-category", method = RequestMethod.POST)
    public String save(@ModelAttribute("category") Category category) {
        repository.save(category);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/delete-category", method = RequestMethod.GET)
    public String delete(@RequestParam("id") final String id) {
        repository.deleteById(id);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/create-category", method = RequestMethod.GET)
    public String create() {
        final Category category = new Category("New Category");
        repository.save(category);
        return "redirect:/categories";
    }
}
