package com.ratings.wsalternativecourseschool.controller;

import com.ratings.wsalternativecourseschool.model.Course;
import com.ratings.wsalternativecourseschool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/school")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Map> getAll(){
        return courseService.getAll();
    }
}
