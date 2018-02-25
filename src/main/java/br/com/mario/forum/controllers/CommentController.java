package br.com.mario.forum.controllers;

import br.com.mario.forum.model.Comment;
import br.com.mario.forum.repositories.CommentRepository;
import br.com.mario.forum.repositories.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mario on 24/02/18.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    private CommentRepository commentRepository;
    private TopicRepository topicRepository;

    public CommentController(CommentRepository commentRepository, TopicRepository topicRepository) {
        this.commentRepository = commentRepository;
        this.topicRepository = topicRepository;
    }

    @PostMapping
    public ModelAndView postComment(Comment comment){
        long topicId = comment.getTopic().getId();
        ModelAndView page = new ModelAndView("redirect:/topic/"+topicId);
        commentRepository.save(comment);
        page.addObject("topic",topicRepository.findById(topicId));

        return page;
    }
}
