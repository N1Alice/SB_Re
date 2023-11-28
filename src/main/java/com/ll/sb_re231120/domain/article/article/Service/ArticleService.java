package com.ll.sb_re231120.domain.article.article.Service;

import com.ll.sb_re231120.domain.article.article.entity.Article;
import com.ll.sb_re231120.domain.article.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 나는 단 한번만 생성되고, 그이후에는 재사용되는 객체 입니다.
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired // 생성자 주입
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

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
