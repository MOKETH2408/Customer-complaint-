package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired 
    private UserRepo userRepo;
    
    @GetMapping
    public List<User> getUser()
    {
        return userRepo.findAll();
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateuser(@PathVariable int userId,@RequestBody User user)
    {
        User existing = userRepo.findById(userId).orElse(null);
        if(existing==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());
        existing.setFullName(user.getFullName());
        existing.setUsername(user.getUsername());
        userRepo.save(existing);
        return new ResponseEntity<>(existing,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> adduser(@RequestBody User user){
        try{
            userRepo.save(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId)
    {
        User a=userRepo.findById(userId).orElse(null);
        if(a==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(a,HttpStatus.OK);

    }

    @GetMapping("/page/{offset}/{page}")
    public Page<User> getPageWithPage(@PathVariable int offset,@PathVariable int page){
        Pageable pageable = PageRequest.of(offset,page);
        return userRepo.findAll(pageable);
    }
    @GetMapping("/role/{a}")
    public ResponseEntity<?> getbyrole(@PathVariable String a)
    {
        List<User> b=userRepo.findByRole(a);
        if(b==null || b.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found with role: "+a);
        }
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
    @GetMapping("/email/{a}")
    public ResponseEntity<?> getByEmail(@PathVariable String a)
    {
        User b=userRepo.findByEmail(a);
        if(b==null)  
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with email: "+a);
        }
        return new ResponseEntity<>(b,HttpStatus.OK);
    }

}
