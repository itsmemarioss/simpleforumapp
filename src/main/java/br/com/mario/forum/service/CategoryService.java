package br.com.mario.forum.service;

import br.com.mario.forum.model.Category;
import br.com.mario.forum.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mario on 24/02/18.
 */
@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }
}
