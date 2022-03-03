package com.ibm.academy.cinema.apirest.filmservice.service;

import com.ibm.academy.cinema.apirest.filmservice.entity.Category;

public interface CategoryService extends GenericService<Category> {
    Category update(Long id, Category category);
}
