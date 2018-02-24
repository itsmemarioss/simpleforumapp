package br.com.mario.forum.converters;

import br.com.mario.forum.model.Category;
import br.com.mario.forum.repositories.CategoryRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by mario on 24/02/18.
 */
@Component
public class CategoryConverter implements Converter<Long, Category> {

    private CategoryRepository repository;

    public CategoryConverter(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category convert(Long id) {
        return repository.findById(id).get();
    }
}
