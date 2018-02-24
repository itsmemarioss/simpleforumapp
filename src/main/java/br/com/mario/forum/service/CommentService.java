package br.com.mario.forum.service;

import br.com.mario.forum.model.Comment;
import br.com.mario.forum.repositories.CommentRepository;
import org.springframework.stereotype.Controller;

/**
 * Created by mario on 23/02/18.
 */
@Controller
public class CommentService {

    private CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public void save(Comment comment){
        repository.save(comment);
    }
}
