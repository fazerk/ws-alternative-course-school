package com.ratings.wsalternativecourseschool.service;

import com.ratings.wsalternativecourseschool.exception.ConflictException;
import com.ratings.wsalternativecourseschool.exception.NotFoundException;
import com.ratings.wsalternativecourseschool.model.Course;
import com.ratings.wsalternativecourseschool.model.Score;
import com.ratings.wsalternativecourseschool.model.Student;
import com.ratings.wsalternativecourseschool.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    public void add(Long studentId, Long courseId,  Float rating){
        //Validations
        if(rating < 0 || rating > 10){
            throw new ConflictException("La calificación debe estar en un rango de 0 a 10.");
        }
        Student student = studentService.getById(studentId).
                orElseThrow( ()-> new NotFoundException("No se encontró el alumno."));
        Course course = courseService.getById(courseId).
                orElseThrow( ()-> new NotFoundException("No se encontró la materia."));

        Score scoreFind = scoreRepository.findByCourseAndStudent(course, student);
        if (scoreFind != null){
            throw new ConflictException("La calificación ya se encuentra registrada.");
        }

        // Create and save score
        Score score = new Score();
        score.setStudent(student);
        score.setCourse(course);
        score.setScore(rating);
        score.setRegisteredAt(LocalDateTime.now());
        scoreRepository.save(score);
    }

    public List<Map> getByStudent(Long studentId){
        Student student = studentService.getById(studentId).
                orElseThrow( ()-> new NotFoundException("No se encontró el alumno."));
        List<Score> ratings = scoreRepository.findByStudent(student);
        List<Map> ratingProcessed = new ArrayList<>();
        AtomicReference<Float> ratingSum = new AtomicReference<>((float) 0);
        ratings.forEach((rating) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id_t_usuario", rating.getStudent().getId());
            map.put("nombre", rating.getStudent().getName());
            map.put("apellido_paterno", rating.getStudent().getSurname());
            map.put("apellido_materno", rating.getStudent().getSecondSurname());
            map.put("id_t_materias",rating.getCourse().getId() );
            map.put("materia", rating.getCourse().getName());
            map.put("id_t_calificaciones", rating.getId());
            map.put("calificacion", rating.getScore());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            map.put("fecha_registro", rating.getRegisteredAt().format(formatter));
            ratingSum.set(ratingSum.get() + rating.getScore());
            ratingProcessed.add(map);
        });

        Map<String, Object> averageMap = new HashMap<>();
        averageMap.put("promedio", ratingSum.get() / ratings.size());
        ratingProcessed.add(averageMap);
        return ratingProcessed;
    }

    public void update(Long id, float rating){
        Score score = scoreRepository.findById(id).
                orElseThrow( ()-> new NotFoundException("No se encontró la materia."));
        score.setScore(rating);
        scoreRepository.save(score);
    }

    public void delete(Long id){
        Score score = scoreRepository.findById(id).
                orElseThrow( ()-> new NotFoundException("No se encontró la materia."));
        scoreRepository.delete(score);
    }
}
