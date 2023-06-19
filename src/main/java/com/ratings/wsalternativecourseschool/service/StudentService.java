package com.ratings.wsalternativecourseschool.service;

import com.ratings.wsalternativecourseschool.model.Student;
import com.ratings.wsalternativecourseschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findByActive(1);
    }
    public Optional<Student> getById(Long id){
        return studentRepository.findById(id);
    }
}
