package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.repository.CategoryRepo;
import java.util.List;
import com.examly.springapp.model.Category;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired CategoryRepo repo;
    @PostMapping
    public ResponseEntity<Category> addUser(@RequestBody Category category)
    {
        try{
            
            return new ResponseEntity<>(repo.save(category),HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Category>> getallUser()
    {
        List<Category>a=repo.findAll();
        if(a.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getbyId(@PathVariable int id)
    {
        Category a=repo.findById(id).orElse(null);
        if(a==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
}
