package com.ibm.academy.cinema.apirest.filmservice.service.impl;

import com.ibm.academy.cinema.apirest.filmservice.entity.Category;
import com.ibm.academy.cinema.apirest.filmservice.repository.CategoryRepository;
import com.ibm.academy.cinema.apirest.filmservice.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryRepository> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public Category update(Long id, Category category) {
        return null;
    }
}
