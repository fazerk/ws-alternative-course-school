package com.ratings.wsalternativecourseschool.repository;

import com.ratings.wsalternativecourseschool.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByActive(Integer active);
}
