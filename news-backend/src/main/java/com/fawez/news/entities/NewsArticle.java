package com.fawez.news.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsArticle {
    private String title;
    private String description;
    private String url;
    private String publishedAt;
    private String sourceName;
}
