package com.techbook.api.config;

import com.techbook.api.entity.Todo;
import com.techbook.api.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {
        return args -> {
            repository.deleteAll();

            Todo todo1 = new Todo(null, "Learn Spring Boot", "Understand the basics", false);
            Todo todo2 = new Todo(null, "Build a REST API", "Develop endpoints using Spring Boot", true);
            Todo todo3 = new Todo(null, "Deploy to Docker", "Containerize the application", false);

            repository.saveAll(List.of(todo1, todo2, todo3));
        };
    }
}
