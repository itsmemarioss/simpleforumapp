package br.com.mario.forum.controllers;

import br.com.mario.forum.model.Category;
import br.com.mario.forum.model.Topic;
import br.com.mario.forum.service.CategoryService;
import br.com.mario.forum.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * Created by mario on 23/02/18.
 */
@Controller
@RequestMapping("/topic")
public class TopicController {

    private TopicService service;
    private CategoryService categoryService;

    public TopicController(TopicService service, CategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @RequestMapping("/new")
    public ModelAndView newTopic(){
        ModelAndView form = new ModelAndView("new-topic");
        form.addObject("categories", categoryService.findAll());
        return form;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public RedirectView postTopic(Topic topic, RedirectAttributes attr){

        service.save(topic);

        RedirectView index = new RedirectView("/");
        attr.addFlashAttribute("msg", "New topic added!");

        return index;
    }

    @RequestMapping("{id}")
    public ModelAndView viewTopic(@PathVariable Long id){
        ModelAndView detail = new ModelAndView("topic");
        detail.addObject("topic", service.findById(id));
        return detail;

    }

    @ModelAttribute
    public List<Category> allCategories(){
        return categoryService.findAll();
    }
}
