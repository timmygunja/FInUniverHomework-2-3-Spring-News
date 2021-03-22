package com.example.demo.controller;

import com.example.demo.entity.News;
import com.example.demo.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController {
    private final NewService newService;

    @Autowired
    public RestApiController(NewService newService){
        this.newService = newService;
    }

    @PostMapping(value = "/api/news")
    public ResponseEntity<?> create(@RequestBody News news){
        newService.create(news);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/news")
    public ResponseEntity<List<News>> findAll(){
        final List<News> newList = newService.findAll();

        return newList != null && !newList.isEmpty()
                ? new ResponseEntity<>(newList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/news/{id}")
    public ResponseEntity<News> find(@PathVariable(name="id") Long id){
        final News news = newService.find(id);

        return news != null
                ? new ResponseEntity<>(news, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
