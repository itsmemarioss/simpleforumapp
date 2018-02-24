package br.com.mario.forum.bootstrap;

import br.com.mario.forum.model.Category;
import br.com.mario.forum.model.Topic;
import br.com.mario.forum.repositories.CategoryRepository;
import br.com.mario.forum.repositories.TopicRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by mario on 23/02/18.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private TopicRepository topicRepository;

    public DevBootstrap(CategoryRepository categoryRepository, TopicRepository topicRepository) {
        this.categoryRepository = categoryRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        categoryRepository.saveAll(
            Arrays.asList(
                new Category("Java"),
                new Category("Linux"),
                new Category("PostgreSQL"),
                new Category("SQL"),
                new Category("Spring")
            )
        );

        topicRepository.save(new Topic("Is Java the best language ever?", "Some Texte in this topip"));
        topicRepository.save(new Topic("How to programm effectively", "Some Texte in this topip"));
    }
}
