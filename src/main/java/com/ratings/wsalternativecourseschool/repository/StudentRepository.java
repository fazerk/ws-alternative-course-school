package com.ratings.wsalternativecourseschool.repository;

import com.ratings.wsalternativecourseschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByActive(Integer active);
}
