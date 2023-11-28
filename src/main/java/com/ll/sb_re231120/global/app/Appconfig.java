package com.ll.sb_re231120.global.app;

import com.ll.sb_re231120.domain.article.article.entity.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Appconfig {
    @Bean
    List<Article> articles2() {
        return new java.util.LinkedList<>();
    }

    @Bean
    List<Article> articles(){
        return new java.util.ArrayList<>();
    }
}
