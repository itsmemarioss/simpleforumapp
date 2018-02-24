package br.com.mario.forum.converters;

import br.com.mario.forum.model.Topic;
import br.com.mario.forum.repositories.TopicRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by mario on 24/02/18.
 */
@Component
public class TopicConverter implements Converter<Long,Topic>{

    private TopicRepository repository;

    @Override
    public Topic convert(Long id) {
        return repository.findById(id).orElseGet(Topic::new);
    }
}
