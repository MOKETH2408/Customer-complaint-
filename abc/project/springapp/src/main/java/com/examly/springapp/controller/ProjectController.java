    package com.examly.springapp.controller;
    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.examly.springapp.model.Project;
import com.examly.springapp.repository.ProjectRepo;
    @RequestMapping("/api/projects")
    @RestController
    public class ProjectController {
        @Autowired
        private ProjectRepo projectRepo;

        @GetMapping("/{id}")
        public Project disp(@PathVariable int id)
        {
            return projectRepo.findById(id).orElse(null);
        }
        @PostMapping
        public ResponseEntity<Project> adduser(@RequestBody Project project)
        {
            try{
                return new ResponseEntity<>(projectRepo.save(project),HttpStatus.CREATED);
            }
            catch(Exception e)
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        @GetMapping
        public ResponseEntity<List<Project>> getall()
        {
            List<Project> a=projectRepo.findAll();
            if(a.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.status(HttpStatus.OK).body(a);
        }
        @PutMapping("/{id}")
        public ResponseEntity<Project> updateProject(@PathVariable int id,@RequestBody Project project)
        {
            Project a=projectRepo.findById(id).orElse(null);
            if(a!=null)
            {
                a.setDescription(project.getDescription());
                a.setProjectName(project.getProjectName());
                a.setStatus(project.getStatus());
                projectRepo.save(a);
                return new ResponseEntity<>(a,HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } 
        @GetMapping("/status/{a}")
        public ResponseEntity<?> getbystatus(@PathVariable String a)
        {
            List<Project> b=projectRepo.findByStatus(a);
            if(b==null || b.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No projects found with status: "+a);
            }
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
    }
