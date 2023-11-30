package com.ll.sb_re231120.domain.article.article.controller;

import com.ll.sb_re231120.domain.article.article.Service.ArticleService;
import com.ll.sb_re231120.domain.article.article.entity.Article;
import com.ll.sb_re231120.global.rq.Rq;
import com.ll.sb_re231120.global.rsData.RsData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Validated
public class ArticleController {
    private final ArticleService articleService;
    private final Rq rq;

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData write(
            @NotBlank(message = "제목좀..") String title,
            @NotBlank String body
    ) {

        Article article = articleService.write(title, body);
        RsData<Article> rs = new RsData(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );

        String resultCode = rs.getResultCode();
        String msg = rs.getMsg();
        Article _article = rs.getData();
        return rs;
    }


    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articleService.findLastArticle();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articleService.findAll();
    }


    @GetMapping("/article/articleServicePointer")
    @ResponseBody
    String articleServicePointer() {
        return articleService.toString();
    }

    @GetMapping("/article/httpServletRequestPointer")
    @ResponseBody
    String httpServletRequestPointer(HttpServletRequest req) {
        return req.toString();
    }

    @GetMapping("/article/httpServletResponsePointer")
    @ResponseBody
    String httpServletResponsePointer(HttpServletResponse resp) {
        return resp.toString();
    }

    @GetMapping("/article/rqPointer")
    @ResponseBody
    String rqPointer() {
        return rq.toString();
    }

    @GetMapping("/article/rqTest")
    String showRqTest(Model model) {
        String rqToString = rq.toString();

        model.addAttribute("rqToString", rqToString);

        return "article/rqTest";
    }
}


