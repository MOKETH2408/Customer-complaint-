package com.examly.springapp.repository;
import com.examly.springapp.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
List<User> findByRole(String role);
User findByEmail(String email);
}
