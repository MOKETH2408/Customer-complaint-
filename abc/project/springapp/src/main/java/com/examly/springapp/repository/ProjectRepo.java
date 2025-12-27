package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.examly.springapp.model.Project;
@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {
    List<Project> findByStatus(String status);
}
