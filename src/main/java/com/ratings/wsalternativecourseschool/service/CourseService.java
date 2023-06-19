package com.ratings.wsalternativecourseschool.service;

import com.ratings.wsalternativecourseschool.model.Course;
import com.ratings.wsalternativecourseschool.model.Score;
import com.ratings.wsalternativecourseschool.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Optional<Course> getById(Long id){
        return courseRepository.findById(id);
    }

    public List<Map> getAll(){
        List<Map> coursesProcessed = new ArrayList<>();
        List<Course> courses = courseRepository.findByActive(1);
        courses.forEach((course -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", course.getId());
            map.put("name", course.getName());
            coursesProcessed.add(map);
        }));

        return coursesProcessed;
    }
}
