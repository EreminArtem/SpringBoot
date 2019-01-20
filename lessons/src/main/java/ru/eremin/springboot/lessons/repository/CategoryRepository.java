package ru.eremin.springboot.lessons.repository;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.eremin.springboot.lessons.entity.Category;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CategoryRepository {

    private Map<String, Category> categories = new LinkedHashMap<>();

    @PostConstruct
    public void init(){
        merge(new Category("cat1"));
        merge(new Category("cat2"));
    }

    public Collection<Category> findAll() {
        return categories.values();
    }

    public Category findById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return categories.get(id);
    }

    public void merge(@Nullable final Category category) {
        if (category == null) return;
        if (category.getId() == null || category.getId().isEmpty()) return;
        categories.put(category.getId(), category);
    }

    public void delete(@Nullable final String id) {
        if (id == null || id.isEmpty()) return;
        categories.remove(id);
    }
}
