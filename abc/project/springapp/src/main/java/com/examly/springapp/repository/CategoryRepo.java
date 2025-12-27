package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Category;
public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
