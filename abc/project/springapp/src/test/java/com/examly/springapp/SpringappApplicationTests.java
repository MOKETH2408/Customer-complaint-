package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void Day3_test_Controller_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller").isDirectory());
    }

    @Test
    @Order(2)
    void Day3_test_Model_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model").isDirectory());
    }

    @Test
    @Order(3)
    void Day3_test_Service_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service").isDirectory());
    }

    @Test
    @Order(4)
    void Day3_test_Repository_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository").isDirectory());
    }

    @Test
    @Order(5)
    void Day4_test_UserModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/User.java").isFile());
    }

    @Test
    @Order(6)
    void Day4_test_ProjectModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Project.java").isFile());
    }

    @Test
    @Order(7)
    void Day4_test_Ticket_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Ticket.java").isFile());
    }

    @Test
    @Order(8)
    void Day4_test_Comment_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Comment.java").isFile());
    }

    @Test
    @Order(9)
    void Day4_test_Category_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Category.java").isFile());
    }

    @Test
    @Order(10)
    void Day4_test_Ticket_Has_Entity_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.model.Ticket");
            Class<?> annotation = Class.forName("jakarta.persistence.Entity");

            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Entity annotation is missing on Ticket class");

        } catch (ClassNotFoundException e) {
            fail("❌ Ticket class not found.");
        } catch (Exception e) {
            fail("❌ Unable to check @Entity annotation on Ticket.");
        }
    }

    @Test
    @Order(11)
    void test_Ticket_Has_Id_Annotation_On_Field() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.model.Ticket");
            Class<?> idAnnotation = Class.forName("jakarta.persistence.Id");

            boolean found = false;

            for (var field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent((Class<? extends Annotation>) idAnnotation)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No field in Ticket class is annotated with @Id");

        } catch (ClassNotFoundException e) {
            fail("❌ Ticket class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Id annotation in Ticket class.");
        }
    }

    @Test
    @Order(12)
    void Day5_testUserRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/UserRepo.java").isFile());
    }

    @Test
    @Order(13)
    void Day5_testProjectRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/ProjectRepo.java").isFile());
    }

    @Test
    @Order(14)
    void Day5_testTicketRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/TicketRepo.java").isFile());
    }

    @Test
    @Order(15)
    void Day5_testCommentRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/CommentRepo.java").isFile());
    }

    @Test
    @Order(16)
    void Day5_testCategoryRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/CategoryRepo.java").isFile());
    }

    @Test
    @Order(17)
    void Day5_test_TicketRepo_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.TicketRepo");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            assertTrue(
                    clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Repository annotation is missing on TicketRepo class");

        } catch (ClassNotFoundException e) {
            fail("❌ TicketRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on TicketRepo.");
        }
    }

    @Test
    @Order(18)
    void Day5_test_UserRepo_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.UserRepo");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            assertTrue(
                    clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Repository annotation is missing on UserRepo class");

        } catch (ClassNotFoundException e) {
            fail("❌ UserRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on UserRepo.");
        }
    }

    @Test
    @Order(19)
    void Day6_test_UserController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/UserController.java").isFile());
    }

    @Test
    @Order(20)
    void Day6_test_ProjectController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/ProjectController.java").isFile());
    }

    @Test
    @Order(21)
    void Day6_test_TicketController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/TicketController.java").isFile());
    }

    @Test
    @Order(22)
    void Day6_test_UserController_Has_RestController_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");

            assertTrue(
                    clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @RestController annotation is missing on UserController class");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RestController annotation on UserController.");
        }
    }

    @Test
    @Order(23)
    void Day6_test_TicketController_Has_RestController_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TicketController");
            Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");

            assertTrue(
                    clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @RestController annotation is missing on TicketController class");

        } catch (ClassNotFoundException e) {
            fail("❌ TicketController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RestController annotation on TicketController.");
        }
    }

    @Test
    @Order(24)
    void Day6_test_UserController_Has_PostMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> postMapping = Class.forName("org.springframework.web.bind.annotation.PostMapping");

            boolean found = false;

            for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) postMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No method with @PostMapping found in UserController");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PostMapping annotation in UserController.");
        }
    }

    @Test
    @Order(25)
    void Day6_test_UserController_Has_GetMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> getMapping = Class.forName("org.springframework.web.bind.annotation.GetMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) getMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @GetMapping method found in UserController");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @GetMapping in UserController.");
        }
    }

    @Test
    @Order(26)
    void Day6_test_UserController_Has_PutMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> putMapping = Class.forName("org.springframework.web.bind.annotation.PutMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) putMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @PutMapping method found in UserController");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PutMapping in UserController.");
        }
    }

   

    @Test
    @Order(27)
    void Day7_test_UserController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on UserController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in UserController.");
        }
    }

    @Test
    @Order(28)
    void Day7_test_UserController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }

            assertTrue(found, "❌ No @PathVariable annotation found in any method parameter of UserController");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in UserController.");
        }
    }

    @Test
    @Order(29)
    void Day7_test_TicketController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TicketController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on TicketController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ TicketController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in TicketController.");
        }
    }

    @Test
    @Order(30)
    void Day7_test_ProjectController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.ProjectController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on ProjectController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ ProjectController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in ProjectController.");
        }
    }

    @Test
    @Order(31)
    void Day7_test_TicketController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TicketController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of TicketController");

        } catch (ClassNotFoundException e) {
            fail("❌ TicketController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in TicketController.");
        }
    }

    @Test
    @Order(32)
    void Day7_test_ProjectController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.ProjectController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of ProjectController");

        } catch (ClassNotFoundException e) {
            fail("❌ ProjectController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in ProjectController.");
        }
    }

    @Test
    @Order(33)
    void Day7_test_CategoryController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CategoryController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on CategoryController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ CategoryController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in CategoryController.");
        }
    }

    @Test
    @Order(34)
    void Day8_test_UserService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/UserService.java").isFile());
    }

    @Test
    @Order(35)
    void Day8_test_ProjectService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/ProjectService.java").isFile());
    }

    @Test
    @Order(36)
    void Day8_test_TicketService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/TicketService.java").isFile());
    }

    @Test
    @Order(37)
    public void Day8_testAddUser() throws Exception {
        String requestBody = "{ \"username\": \"johndoe\", \"email\": \"john@example.com\", \"fullName\": \"John Doe\", \"role\": \"Developer\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("johndoe"))
                .andReturn();
    }

    @Test
    @Order(38)
    public void Day8_testGetAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("johndoe"))
                .andReturn();
    }

    @Test
    @Order(39)
    public void Day8_testGetUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("johndoe"))
                .andReturn();
    }

    @Test
    @Order(40)
    public void Day8_testUpdateUser() throws Exception {
        String requestBody = "{\"username\": \"johndoe\", \"email\": \"john.updated@example.com\", \"fullName\": \"John Updated\", \"role\": \"Developer\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.fullName").value("John Updated"))
                .andReturn();
    }

    @Test
    @Order(41)
    public void Day9_testPagination_PageNumberApplied() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageNumber").value(0));
    }

    @Test
    @Order(42)
    public void Day9_testPagination_PageSizeApplied() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/1/10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageSize").value(10));
    }

    @Test
    @Order(43)
    public void Day9_testPagination_SortingPresent() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort.sorted").isBoolean());
    }

    @Test
    @Order(44)
    public void Day9_testPagination_ContentArrayExists() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray());
    }

    @Test
    @Order(45)
    public void Day9_testPagination_TotalElementsExists() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").exists());
    }

    @Test
    @Order(46)
    public void Day9_testPagination_TotalPagesExists() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages").exists());
    }

    @Test
    @Order(47)
    public void Day10_testAddProject() throws Exception {
        String requestBody = "{ \"projectName\": \"CRM System\", \"description\": \"Customer Relationship Management\", \"status\": \"ACTIVE\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.projectName").value("CRM System"))
                .andReturn();
    }

    @Test
    @Order(48)
    public void Day10_testGetAllProjects() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/projects")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].projectName").value("CRM System"))
                .andReturn();
    }

    @Test
    @Order(49)
    public void Day10_testGetProjectById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/projects/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.projectName").value("CRM System"))
                .andReturn();
    }

    @Test
    @Order(50)
    public void Day10_testUpdateProject() throws Exception {
        String requestBody = "{ \"projectName\": \"CRM System Updated\", \"description\": \"Updated Description\", \"status\": \"ACTIVE\" }";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/projects/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.projectName").value("CRM System Updated"))
                .andReturn();
    }

    @Test
    @Order(51)
    public void Day10_testAddCategory() throws Exception {
        String requestBody = "{ \"categoryName\": \"Bug\", \"description\": \"Software bugs and issues\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.categoryName").value("Bug"))
                .andReturn();
    }

    @Test
    @Order(52)
    public void Day10_testGetAllCategories() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].categoryName").value("Bug"))
                .andReturn();
    }

    @Test
    @Order(53)
    public void Day10_testGetCategoryById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryId").value(1))
                .andReturn();
    }

    @Test
    @Order(54)
    public void Day11_testGetProjectsByStatus() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/projects/status/ACTIVE")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].projectName").value("CRM System Updated"))
                .andReturn();
    }

    @Test
    @Order(55)
    public void Day12_testGetUsersByRole() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/role/Developer")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("johndoe"))
                .andReturn();
    }

    @Test
    @Order(56)
    public void Day12_testGetUserByEmail() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/email/john.updated@example.com")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.fullName").value("John Updated"))
                .andReturn();
    }

    @Test
    @Order(57)
    public void Day12_testGetProjectsByStatus_NotFound() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/projects/status/COMPLETED")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().string("No projects found with status: COMPLETED"));
    }

    @Test
    @Order(58)
    public void Day12_testGetUsersByRole_NotFound() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/role/Admin")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("No users found with role: Admin"));
    }

    @Test
    @Order(59)
    public void Day12_testGetUserByEmail_NotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/email/notfound@example.com")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("User not found with email: notfound@example.com"));
    }
    @Test
    @Order(60)
    void Day13_test_exception_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception").isDirectory());
    }

    @Test
    @Order(61)
    void Day13_test_GlobalException_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception/GlobalExceptionHandler.java").isFile());
    }

    @Test
    @Order(62)
    void Day14_test_configuration_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/configuration").isDirectory());
    }

    @Test
    @Order(63)
    public void Day15_testAOPLogFileExists() {
        assertTrue(new File("src/main/java/com/examly/springapp/aop").isDirectory());
    }

}
