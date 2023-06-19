package com.ratings.wsalternativecourseschool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ratings.wsalternativecourseschool.model.Score;
import com.ratings.wsalternativecourseschool.model.Student;
import com.ratings.wsalternativecourseschool.repository.ScoreRepository;
import com.ratings.wsalternativecourseschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/school")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAll(){
        return studentService.getAll();
    }
}
