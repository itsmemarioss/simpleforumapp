package br.com.mario.forum.controllers;

import br.com.mario.forum.repositories.CategoryRepository;
import br.com.mario.forum.repositories.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 23/02/18.
 */
@Controller
public class IndexController {

    private CategoryRepository categories;
    private TopicRepository topics;

    public IndexController(CategoryRepository categories, TopicRepository topics) {
        this.categories = categories;
        this.topics = topics;
    }

    @RequestMapping({"/",""})
    public String getIndex(Model model){
        model.addAttribute("categories", categories.findAll());
        model.addAttribute("topics", topics.findAll());
        return "index";
    }


}
