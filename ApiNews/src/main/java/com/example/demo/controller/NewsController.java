package com.example.demo.controller;

import com.example.demo.model.News;
import com.example.demo.model.NewsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;
import java.util.List;



@RestController
public class NewsController {

    @GetMapping("/news")
    public List<News> getNews(){
        String url= "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=d6b1d82d0488488bbdce3c508a3c64ca";
        RestTemplate template = new RestTemplate();
        NewsResponse response = template.getForObject(url, NewsResponse.class);
        return response != null ? response.getArticles() : Collections.emptyList();
    }
}
