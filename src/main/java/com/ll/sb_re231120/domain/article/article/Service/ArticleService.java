package com.ll.sb_re231120.domain.article.article.Service;

import com.ll.sb_re231120.domain.article.article.entity.Article;
import com.ll.sb_re231120.domain.article.article.repository.ArticleRepository;

import java.util.List;

public class ArticleService {
    private final ArticleRepository articleRepository = new ArticleRepository();


    public Article write(String title, String body) {

        Article article =
                new Article(title, body);

        articleRepository.save(article);

        return article;

    }

    public Article findLastArticle() {
        return articleRepository.findLastArticle();
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
