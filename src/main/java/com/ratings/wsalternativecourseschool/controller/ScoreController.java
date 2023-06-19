package com.ratings.wsalternativecourseschool.controller;

import java.util.List;
import java.util.Map;

import com.ratings.wsalternativecourseschool.response.ResponseHandler;
import com.ratings.wsalternativecourseschool.service.ScoreService;
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
public class ScoreController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/student/{id}/ratings")
    public List<Map> getScoresByStudent(@PathVariable Long id){
        return scoreService.getByStudent(id);
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Object> add(@PathVariable Long studentId, @PathVariable Long courseId, @RequestBody Map<String,Object> body){
        //Save rating
        float rating = Float.parseFloat(body.get("rating").toString());
        scoreService.add(studentId, courseId,  rating);

        return ResponseHandler.ok("Calificación registrada");
    }

    @PutMapping("/rating/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Map<String,Object> body){
        // Update rating
        float rating = Float.parseFloat(body.get("rating").toString());
        scoreService.update(id, rating);

        return ResponseHandler.ok("Calificación actualizada");
    }

    @DeleteMapping("/rating/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id){
        // Delete rating
        scoreService.delete(id);

        return ResponseHandler.ok("Calificación eliminada");
    }
}
