package br.com.mario.forum.service;

import br.com.mario.forum.model.Topic;
import br.com.mario.forum.repositories.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mario on 23/02/18.
 */
@Service
public class TopicService {

    private TopicRepository repository;

    public TopicService(TopicRepository repository) {
        this.repository = repository;
    }

    public List<Topic> getAll(){
        return repository.findAll();
    }

    public void save(Topic t){
        repository.save(t);
    }

    public Topic findById(Long id) {
        return repository.findById(id).orElse(new Topic());
    }
}
