package com.arthur.springit;

import com.arthur.springit.domain.Comment;
import com.arthur.springit.domain.Link;
import com.arthur.springit.repository.CommentRepository;
import com.arthur.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {

            Link link = new Link("Starting Spring Boot", "http://abc.com");
            linkRepository.save(link);

            Comment comment = new Comment("Spring Boot is DOPE", link);
            commentRepository.save(comment);
            link.addComment(comment);


        };
    }

}
