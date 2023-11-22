package com.ll.sb_re231120;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    private List<Article> articles = new ArrayList<>();

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    RsData doWrite(
            String title,
            String body
    ) {
        Article article = new Article(articles.size() + 1, title, body);
// 자동으로 크기 확장
        RsData rs = new RsData(
                "S-1",
                "%d번 게시물이 작성되었습니다.",
                article
        );

        String resultCode = rs.getResultCode();
        String msg = rs.getMsg();
        Article _article = (Article) rs.getData();
//추상적에서 구체적으로 갈때는(형변환) (Article) 해줘야한다 그냥 외워라 약속이다
        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articles;
    }
}

@AllArgsConstructor
@Getter
class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;
    //옛날에는 오브젝트 사용함
}

@AllArgsConstructor
@Getter
class Article {
    private long id;
    private String title;
    private String body;
}
