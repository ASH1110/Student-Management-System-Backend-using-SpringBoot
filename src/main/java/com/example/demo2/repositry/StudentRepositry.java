package com.example.demo2.repositry;

import com.example.demo2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositry extends JpaRepository<Student,Integer> {
}
