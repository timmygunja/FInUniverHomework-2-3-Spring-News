package com.example.demo.service;

import com.example.demo.repository.NewsRepository;
import com.example.demo.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService {
    @Autowired
    private NewsRepository newsRepository;

    public void create(News news){
        newsRepository.save(news);
    }

    public List<News> findAll(){
        return newsRepository.findAll();
    }

    public News find(Long id){
        return newsRepository.findById(id).get();
    }
}
