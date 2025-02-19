package com.fawez.news.controller;

import com.fawez.news.entities.NewsArticle;
import com.fawez.news.services.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin //from where?
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/search")
    public List<NewsArticle> searchNews(@RequestParam String query) {
        return newsService.fetchNews(query);
    }
}
