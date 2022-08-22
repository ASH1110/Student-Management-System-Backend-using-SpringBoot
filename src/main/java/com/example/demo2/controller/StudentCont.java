package com.example.demo2.controller;

import com.example.demo2.model.Student;
import com.example.demo2.repositry.StudentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentCont {

    @Autowired
    StudentRepositry studentRepositry;

    @GetMapping("/listStudent")
    public List<Student> getList(){
        return studentRepositry.findAll();
    }

    @PostMapping("/student")
    public List<Student> addStudent(@RequestBody Student student){
        studentRepositry.save(student);
        return studentRepositry.findAll();
    }

    @DeleteMapping("/deleteStudent/{id}")
    public List<Student> deleteStudent(@PathVariable Integer id)
    {
        studentRepositry.delete(studentRepositry.findById(id).get());
        return studentRepositry.findAll();
    }

    @PutMapping("/update/{id}")
    public List<Student> updateStudent(@RequestBody Student student,@PathVariable Integer id){
        Student studentObj = studentRepositry.findById(id).get();
        studentObj.setId(student.getId());
        studentObj.setAddress(student.getAddress());
        studentRepositry.save(studentObj);
        return studentRepositry.findAll();
    }

    @GetMapping("/viewStudent/{id}")
    public Student view(@PathVariable Integer id){
        return studentRepositry.findById(id).get();
    }

}
