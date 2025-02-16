package com.fawez.news.services;

import com.fawez.news.entities.NewsArticle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NewsService {
    private final String apiKey="74cc5beffae541a0b8d4cd7935e3fce5";
    private final String baseUrl="https://newsapi.org/v2";
    private final RestTemplate restTemplate;

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<NewsArticle> fetchNews(String query) {
        String url = String.format("%s/everything?q=%s&apiKey=%s", baseUrl, query, apiKey);


        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            List<Map<String, Object>> articles = (List<Map<String, Object>>) response.getBody().get("articles");
            return articles.stream()
                    .map(article -> {
                        NewsArticle newsArticle = new NewsArticle();
                        newsArticle.setTitle((String) article.get("title"));
                        newsArticle.setDescription((String) article.get("description"));
                        newsArticle.setUrl((String) article.get("url"));
                        newsArticle.setPublishedAt((String) article.get("publishedAt"));
                        newsArticle.setSourceName((String) ((Map<String, Object>) article.get("source")).get("name"));
                        return newsArticle;
                    })
                    .collect(Collectors.toList());
        } else {
            return List.of();
        }
    }
}
