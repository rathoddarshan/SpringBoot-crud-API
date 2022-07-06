package com.darshan.app.rest.Controller;


import com.darshan.app.rest.Model.Student;
import com.darshan.app.rest.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/")
    public String getPage(){
        return "Welcome";
    }
    @GetMapping(value = "/students")
    public List<Student> getStudents() {
        return studentRepo.findAll();

    }
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody Student student){
        studentRepo.save(student);
        return "saved...";
    }
    @PutMapping(value = "update/{id}")
    public String updateStudent(@PathVariable long id, @RequestBody Student student) {
        Student updateStudent = studentRepo.findById(id).get();
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setAge(student.getAge());
        updateStudent.setRole(student.getRole());
        studentRepo.save(updateStudent);
        return "Updated....";

    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        Student deleteStudent = studentRepo.findById(id).get();
        studentRepo.delete(deleteStudent);
        return "Delete the Student id:" + id;

    }
}
