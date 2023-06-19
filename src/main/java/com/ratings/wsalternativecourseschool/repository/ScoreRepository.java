package com.ratings.wsalternativecourseschool.repository;

import com.ratings.wsalternativecourseschool.model.Score;
import com.ratings.wsalternativecourseschool.model.Course;
import com.ratings.wsalternativecourseschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    public Score findByCourseAndStudent(Course course, Student student);
    public List<Score> findByStudent(Student student);
}
