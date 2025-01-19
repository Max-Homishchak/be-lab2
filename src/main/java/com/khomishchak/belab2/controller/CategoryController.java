package com.khomishchak.belab2.controller;

import com.khomishchak.belab2.model.Category;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/category")
public class CategoryController {
    private final Map<Long, Category> categories = new HashMap<>();
    private Long idCounter = 1L;

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        category.setId(idCounter++);
        categories.put(category.getId(), category);
        return category;
    }

    @GetMapping
    public Collection<Category> getAllCategories() {
        return categories.values();
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categories.remove(categoryId);
    }
}