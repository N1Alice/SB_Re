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
        Article _article = rs.getData();
//나는 형변환이 싫어요
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
class RsData {
    private String resultCode;
    private String msg;
    private Article data;
    //형변환이 귀찮으니 Article로 가자, 범용성을 잃었지만 표리일체다
    //Object는 다 들어올수있지만 나갈때 형변환을 해줘야 한다.
}

@AllArgsConstructor
@Getter
class Article {
    private long id;
    private String title;
    private String body;
}
