package ru.eremin.springboot.lessons.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eremin.springboot.lessons.entity.Category;

/**
 * @autor Eremin Artem on 22.01.2019.
 */

@Repository(CategoryRepository.NAME)
public interface CategoryRepository extends JpaRepository<Category, String> {

    String NAME = "categoryRepository";

    Category findCategoryByName(String name);

}
